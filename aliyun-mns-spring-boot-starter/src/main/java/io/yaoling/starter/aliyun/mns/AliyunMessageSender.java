package io.yaoling.starter.aliyun.mns;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
import io.yaoling.third.exception.ThirdPartyException;
import io.yaoling.third.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
public class AliyunMessageSender implements MessageSender{

    private static Logger logger = LoggerFactory.getLogger(AliyunMessageSender.class);

    @Autowired
    private AliyunMessageSenderPropertiesConfig config;

    public void sendMessage(String templateCode, List<String> phones, Map<String,String> params) throws ThirdPartyException{

        //没有电话号码什么也不发
        if(phones==null||phones.size()==0) return;
        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount(config.getAccessKeyId(), config.getAccessKeySecret(), config.getEndpoint());
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(config.getTopic() );
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName(config.getSignature());
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode( templateCode );
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        if(params!=null) {
            Iterator<Map.Entry<String,String>> kv = params.entrySet().iterator();
            while(kv.hasNext()) {
                Map.Entry<String, String> entry = kv.next();
                smsReceiverParams.setParam(entry.getKey(),entry.getValue());
            }
        }
        // 3.4 增加接收短信的号码
        for (String phone:phones) {
            batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        }
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            logger.debug("MessageId: {}" , ret.getMessageId());
            logger.debug("MessageMD5:{}" , ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            logger.error("Message send failed.", se);
            throw new ThirdPartyException(se.getErrorCode(), se);
        } catch (Exception e) {
            throw new ThirdPartyException(e);
        }
        client.close();
    }

    public void sendMessage(String templateCode, String phone, Map<String, String> params) throws ThirdPartyException {
        this.sendMessage(templateCode, Arrays.asList(phone), params);
    }

}
