package io.yaoling.starter.aliyun.mns;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 短信调用实体
 * <p>
 * Created by  dairutao on 2018/6/08 0024.
 * <p>
 * 江苏摇铃网络科技有限公司。
 */
@ConfigurationProperties(prefix = "yaoling.starter.aliyun.mns")
public class SmsData {
    private String phoneNumbers;//电话号码，多个用逗号分割，批量上限为1000个手机号码

    private String templateCode;//短信模板id

    private String templateParam;//短信模板内容
    private String accessKeyId;//key
    private String accessKeySecret;//secret
    private String signName;//短信签名

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
