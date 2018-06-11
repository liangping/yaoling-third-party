package io.yaoling.starter.weixin.listener;

import io.yaoling.common.utils.ObjectConverter;
import io.yaoling.starter.weixin.WeixinPropertiesConfig;
import io.yaoling.starter.weixin.crypto.AesException;
import io.yaoling.starter.weixin.crypto.WXBizMsgCrypt;
import io.yaoling.starter.weixin.message.DefaultMessage;
import io.yaoling.starter.weixin.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

public class MessageListenerController {

    private static Logger logger = LoggerFactory.getLogger( MessageListenerController.class );

    @Autowired
    private WeixinPropertiesConfig config;

    @Autowired
    MessageListenerLocator locator;

    /**
     * 微信公众号消息处理接口，
     *
     * 注意 ：使用 Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files 8 Download
     *
     * @param appid 微信公众号的 appid
     * @param msg_signature 消息签名
     * @param timestamp 消息时间戳
     * @param nonce 随机字符串
     * @param encrypt_type 消息加密类型
     * @param message 消息体
     * @return 返回消息对象
     */
    @RequestMapping(value = "/weixin/message/api", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public @ResponseBody
    String message(@PathVariable String appid,
                   @RequestParam String msg_signature,
                   @RequestParam String timestamp,
                   @RequestParam String nonce,
                   @RequestParam String encrypt_type,
                   @RequestBody String message) {

        logger.debug("settingid:{}, msg_signature:{}, timestamp:{}, nonce:{}, encrypt_type:{}, message:{}",
                new Object[]{ appid,msg_signature,timestamp,nonce,encrypt_type,message });

        DefaultMessage received = ObjectConverter.xml2Obj(message, DefaultMessage.class);
        //对加密的消息体进行解密
        if(received != null && received.getEncrypt()!=null && received.getEncrypt().length()>0){

            try{

                WXBizMsgCrypt encypt = new WXBizMsgCrypt(config.getToken(), config.getEncodingAesKey(), config.getAppid());

                String mingwen = encypt.decryptMsg(msg_signature, timestamp, nonce, message);
                logger.debug("decrypt message:{}" , mingwen);

                received = ObjectConverter.xml2Obj(mingwen,DefaultMessage.class);

                Message reply  = locator.reply(received, new MessageContext());

                if(logger.isDebugEnabled()){
                    logger.debug( reply.toString() );
                    logger.debug( reply.toEncryptString() );
                }
                if("raw".equalsIgnoreCase(encrypt_type))
                    return reply.toString();
                else{
                    return encypt.encryptMsg( this.toString(),String.valueOf(System.currentTimeMillis()/1000),String.valueOf(new Random().nextInt()) );
                }

            }catch(AesException e){
                logger.error("Weixin AesException",e);
            }
        }
        return "";
    }

}
