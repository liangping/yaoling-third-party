package io.yaoling.starter.weixin;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
@ConfigurationProperties(prefix = "yaoling.starter.weixin")
public class WeixinPropertiesConfig {

    public static final String MODE_DIRECT = "direct";
    public static final String CACHE_LOCAL = "local";

    private boolean enable = false;
    private String appid;
    private String appsecret;
    private String token;
    private String encodingAesKey;
    private String componentAppId;
    private String componentAppSecret;
    private String accessTokenHost;
    private String accessTokenKey;
    private String mode = MODE_DIRECT;
    private String tokenCache = CACHE_LOCAL;
    private String payKey;

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getTokenCache() {
        return tokenCache;
    }

    public void setTokenCache(String tokenCache) {
        this.tokenCache = tokenCache;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public String getAccessTokenHost() {
        return accessTokenHost;
    }

    public void setAccessTokenHost(String accessTokenHost) {
        this.accessTokenHost = accessTokenHost;
    }

    public String getAccessTokenKey() {
        return accessTokenKey;
    }

    public void setAccessTokenKey(String accessTokenKey) {
        this.accessTokenKey = accessTokenKey;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getComponentAppSecret() {
        return componentAppSecret;
    }

    public void setComponentAppSecret(String componentAppSecret) {
        this.componentAppSecret = componentAppSecret;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
