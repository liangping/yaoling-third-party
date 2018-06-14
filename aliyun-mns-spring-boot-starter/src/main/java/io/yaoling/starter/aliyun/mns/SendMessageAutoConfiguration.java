package io.yaoling.starter.aliyun.mns;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 慢性病系统
 * <p>
 * Created by dairutao on 2018/6/8 0008.
 * <p>
 * 江苏摇铃网络科技有限公司。
 */
@Configuration
@EnableConfigurationProperties(SmsData.class)//指定类的配置
@ConditionalOnClass(SendMessageImpl.class)
@ConditionalOnProperty(prefix = "yaoling.starter.aliyun.oss",value = "enable",matchIfMissing = true)//指定的属性是否有指定的值
public class SendMessageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(SendMessageImpl.class)//当容器中没有指定Bean的情况下
    public SendMessageImpl sendMessage(){
        return new SendMessageImpl();
    }
}
