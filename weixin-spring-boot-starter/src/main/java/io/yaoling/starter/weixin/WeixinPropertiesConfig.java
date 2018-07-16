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
    /**
     * 公众号appid
     */
    private String appid;
    /**
     * 公众号密码
     */
    private String appsecret;
    /**
     * 接口通信token
     */
    private String token;
    /**
     * 消息加密KEY
     */
    private String encodingAesKey;
    /**
     * 第三方平台的appid
     */
    private String componentAppId;
    /**
     * 第三方平台的密码
     */
    private String componentAppSecret;
    /**
     * 微信access_token的缓存服务器
     */
    private String accessTokenHost;
    /**
     * 微信access_token的缓存服务器的密码
     */
    private String accessTokenKey;
    /**
     * 微信access_token的获取模式：MODE_DIRECT-从微信接口获取，MODE_CACHED-从缓存服务器获取
     */
    private String mode = MODE_DIRECT;
    /**
     * 微信access_token缓存模式：CACHE_LOCAL-缓存在本地静态类，CACHE_SERVER-缓存到服务器
     */
    private String tokenCache = CACHE_LOCAL;
    /**
     * 支付密码
     */
    private String payKey;
    /**
     * 签名类型
     */
    private String paySignType="MD5";
    /**
     * 微信支付商户号
     */
    private String mch_id;
    /**
     * 支付成功通知地址
     */
    private String notifyHost;

    public String getNotifyHost() {
        return notifyHost;
    }

    public void setNotifyHost(String notifyHost) {
        this.notifyHost = notifyHost;
    }

    public String getPaySignType() {
        return paySignType;
    }

    public void setPaySignType(String paySignType) {
        this.paySignType = paySignType;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

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
