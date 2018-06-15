package io.yaoling.starter.aliyun.mns;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public class AliyunMessageSender {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    private static Logger logger = LoggerFactory.getLogger(AliyunMessageSender.class);

    @Autowired
    private AliyunMessageSenderPropertiesConfig config;


    public SendSmsResponse sendMessage(String phone, String code)throws com.aliyuncs.exceptions.ClientException {
        AliyunMessageSenderPropertiesConfig sms = new AliyunMessageSenderPropertiesConfig();
        sms.setPhoneNumbers(phone);
        sms.setTemplateCode(config.getTemplateCode());
        sms.setTemplateParam("{\"code\":\""+code+"\"}");
        sms.setAccessKeyId(config.getAccessKeyId());
        sms.setAccessKeySecret(config.getAccessKeySecret());
        sms.setSignName(config.getSignName());
        SendSmsResponse response = null;
        try {
            response =sendMessage(sms);
        } catch (com.aliyun.mns.common.ClientException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     *
     * @param sendSms 短信实体
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendMessage(AliyunMessageSenderPropertiesConfig sendSms) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", sendSms.getAccessKeyId(), sendSms.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(sendSms.getPhoneNumbers());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(sendSms.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(sendSms.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(sendSms.getTemplateParam());
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }
}
