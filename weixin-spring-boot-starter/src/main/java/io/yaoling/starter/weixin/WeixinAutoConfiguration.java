package io.yaoling.starter.weixin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liangping on 2017/9/27 0027.
 * <p>
 * 江苏摇铃网络科技有限公司，版权所有。
 * Copyright (C) 2015-2017 All Rights Reserved.
 */
@Configuration
@EnableConfigurationProperties(WeixinPropertiesConfig.class)//指定类的配置
//@ConditionalOnClass(AliyunOSSFileStorage.class)
@ConditionalOnProperty(prefix = "yaoling.starter.weixin",value = "enable",matchIfMissing = true)//指定的属性是否有指定的值
public class WeixinAutoConfiguration {
//    @Bean
//    @ConditionalOnMissingBean(AliyunOSSFileStorage.class)//当容器中没有指定Bean的情况下
//    public AliyunOSSFileStorage aliyunOSSFileStorage(){
//        return new AliyunOSSFileStorage();
//    }

}
