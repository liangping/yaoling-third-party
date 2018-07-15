package io.yaoling.starter.weixin;

import io.yaoling.starter.weixin.component.api.WeixinComponentApi;
import io.yaoling.starter.weixin.listener.message.ConfigSuccessMessageListener;
import io.yaoling.starter.weixin.listener.message.MessageListener;
import io.yaoling.starter.weixin.listener.message.MessageListenerLocator;
import io.yaoling.starter.weixin.listener.payment.PayNotifyListenerLocator;
import io.yaoling.starter.weixin.mp.WeixinApi;
import io.yaoling.starter.weixin.mp.WeixinPayApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
@Configuration
@EnableConfigurationProperties(WeixinPropertiesConfig.class)
@ConditionalOnProperty(prefix = "yaoling.starter.weixin", value = "enable",havingValue = "true",matchIfMissing = true)//指定的属性是否有指定的值
@ComponentScan("io.yaoling.starter.weixin.listener")
public class WeixinAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(WeixinApi.class)
    public WeixinApi weixinApi(){
        return new WeixinApi();
    }

    @Bean
    @ConditionalOnMissingBean(WeixinPayApi.class)
    public WeixinPayApi weixinPayApi(){
        return new WeixinPayApi();
    }

    @Bean
    @ConditionalOnMissingBean(WeixinComponentApi.class)
    public WeixinComponentApi weixinComponentApi(){
        return new WeixinComponentApi();
    }

    @Bean
    @ConditionalOnMissingBean(MessageListenerLocator.class)
    public MessageListenerLocator messageListenerLocator(){
        return new MessageListenerLocator();
    }

    @Bean
    @ConditionalOnMissingBean(PayNotifyListenerLocator.class)
    public PayNotifyListenerLocator payNotifyListenerLocator(){
        return new PayNotifyListenerLocator();
    }

    @Bean
    @ConditionalOnMissingBean(MessageListener.class)
    public ConfigSuccessMessageListener configSuccessMessageListener(){
        return new ConfigSuccessMessageListener();
    }

}
