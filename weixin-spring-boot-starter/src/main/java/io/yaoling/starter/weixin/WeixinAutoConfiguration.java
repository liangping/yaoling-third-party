package io.yaoling.starter.weixin;

import io.yaoling.starter.weixin.component.api.WeixinComponentApi;
import io.yaoling.starter.weixin.listener.AbstractWeixinPayNotifyHandler;
import io.yaoling.starter.weixin.listener.MessageListenerController;
import io.yaoling.starter.weixin.listener.MessageListenerLocator;
import io.yaoling.starter.weixin.listener.PayNotifyListenerController;
import io.yaoling.starter.weixin.mp.WeixinApi;
import io.yaoling.starter.weixin.mp.WeixinPayApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
@Configuration
@EnableConfigurationProperties(WeixinPropertiesConfig.class)//指定类的配置
@ConditionalOnClass(WeixinApi.class)
@ConditionalOnProperty(prefix = "yaoling.starter.weixin",value = "enable",matchIfMissing = true)//指定的属性是否有指定的值
public class WeixinAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(WeixinApi.class)//当容器中没有指定Bean的情况下
    public WeixinApi weixinApi(){
        return new WeixinApi();
    }

    @Bean
    @ConditionalOnMissingBean(WeixinPayApi.class)//当容器中没有指定Bean的情况下
    public WeixinPayApi weixinPayApi(){
        return new WeixinPayApi();
    }

    @Bean
    @ConditionalOnMissingBean(WeixinComponentApi.class)//当容器中没有指定Bean的情况下
    public WeixinComponentApi weixinComponentApi(){
        return new WeixinComponentApi();
    }

    @Bean
    @ConditionalOnMissingBean(MessageListenerController.class)
    public MessageListenerController messageListenerController(){
        return new MessageListenerController();
    }

    @Bean
    @ConditionalOnMissingBean(MessageListenerLocator.class)
    public MessageListenerLocator messageListenerLocator(){
        return new MessageListenerLocator();
    }

    @Bean
    @ConditionalOnBean(AbstractWeixinPayNotifyHandler.class)
    public PayNotifyListenerController payNotifyListenerController(){
        return new PayNotifyListenerController();
    }
}
