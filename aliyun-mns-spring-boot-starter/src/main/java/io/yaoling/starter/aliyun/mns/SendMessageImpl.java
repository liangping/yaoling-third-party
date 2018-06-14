package io.yaoling.starter.aliyun.mns;

import com.aliyun.mns.common.ClientException;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 慢性病系统
 * <p>
 * Created by dairutao on 2018/6/8 0008.
 * <p>
 * 江苏摇铃网络科技有限公司。
 */
public class SendMessageImpl {

    @Autowired
    private SmsData smsData;

    public SendSmsResponse sendMessage(String phone, String code)throws com.aliyuncs.exceptions.ClientException {
        SmsData sms = new SmsData();
        sms.setPhoneNumbers(phone);
        sms.setTemplateCode(smsData.getTemplateCode());
        sms.setTemplateParam("{\"code\":\""+code+"\"}");
        sms.setAccessKeyId(smsData.getAccessKeyId());
        sms.setAccessKeySecret(smsData.getAccessKeySecret());
        sms.setSignName(smsData.getSignName());
        SendSmsResponse response = null;
        try {
            response = SendMessage.sendMessage(sms);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }
}
