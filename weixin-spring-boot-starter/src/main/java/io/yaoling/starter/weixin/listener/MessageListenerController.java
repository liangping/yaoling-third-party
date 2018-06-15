package io.yaoling.starter.weixin.listener;

import io.yaoling.common.utils.ObjectConverter;
import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.starter.weixin.crypto.AesException;
import io.yaoling.starter.weixin.crypto.SHA1;
import io.yaoling.starter.weixin.crypto.WXBizMsgCrypt;
import io.yaoling.starter.weixin.message.DefaultMessage;
import io.yaoling.starter.weixin.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

@Controller
public class MessageListenerController {

    private static Logger logger = LoggerFactory.getLogger( MessageListenerController.class );

    @Autowired
    private WeixinPropertiesConfig config;

    @Autowired
    MessageListenerLocator locator;

    /**
     * 验证token
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/weixin/message/api", method = RequestMethod.GET)
    @ResponseBody
    public String validate(@RequestParam String signature, @RequestParam String timestamp,
                           @RequestParam String nonce, @RequestParam String echostr) {
        if (signature == null) {
            return "failure";
        }

        String[] params = { nonce, timestamp, config.getToken()};
        Arrays.sort(params);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]);
        }
        try {
            String sign = SHA1.encode(sb.toString());
            return signature.equals(sign) ? echostr : "failure";
        }catch (NoSuchAlgorithmException e){
            return "failure";
        }
    }

    /**
     * 微信公众号消息处理接口，
     *
     * 注意 ：使用 Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 8 Download
     *
     * @param signature 消息签名
     * @param timestamp 消息时间戳
     * @param nonce 随机字符串
     * @param openid 消息加密类型
     * @param message 消息体
     * @return 返回消息对象
     */
    @RequestMapping(value = "/weixin/message/api", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public @ResponseBody
    String message(@RequestParam String signature,
                   @RequestParam String timestamp,
                   @RequestParam String nonce,
                   @RequestParam String openid,
                   @RequestBody String message) {

        logger.debug("appid:{}, signature:{}, timestamp:{}, nonce:{}, openid:{}, message:{}",
                new Object[]{ config.getAppid(),signature,timestamp,nonce,openid,message });

        DefaultMessage received = ObjectConverter.xml2Obj(message, DefaultMessage.class);
        //对加密的消息体进行解密
        if(received != null && received.getEncrypt()!=null && received.getEncrypt().length()>0){

            try{

                WXBizMsgCrypt encypt = new WXBizMsgCrypt(config.getToken(), config.getEncodingAesKey(), config.getAppid());

                String mingwen = encypt.decryptMsg(signature, timestamp, nonce, message);
                logger.debug("decrypt message:{}" , mingwen);

                received = ObjectConverter.xml2Obj(mingwen,DefaultMessage.class);

                Message reply  = locator.reply(received, new MessageContext());

                if(logger.isDebugEnabled()){
                    logger.debug( reply.toString() );
                    logger.debug( reply.toEncryptString() );
                }

                return encypt.encryptMsg( this.toString(),String.valueOf(System.currentTimeMillis()/1000),String.valueOf(new Random().nextInt()) );


            }catch(AesException e){
                logger.error("Weixin AesException",e);
            }
            return "";
        }else {
            //明文消息处理
            Message reply  = locator.reply(received, new MessageContext());
            return reply.toString();
        }
    }

}
