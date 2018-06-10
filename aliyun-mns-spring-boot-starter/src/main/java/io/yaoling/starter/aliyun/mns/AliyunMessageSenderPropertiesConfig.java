package io.yaoling.starter.aliyun.mns;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
@ConfigurationProperties(prefix = "yaoling.starter.aliyun.mns")
public class AliyunMessageSenderPropertiesConfig {
    private boolean enable = false;
    private String endpoint="";
    private String accessKeyId="";
    private String accessKeySecret="";
    private String topic="";
    private String signature;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
