package com.aishang.rulemanager.assembly.config.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * dubbo配置
 */
@Configuration
@DubboComponentScan(basePackages = {"com.aishang.rulemanager.adapter.provider", "com.aishang.rulemanager.web"})
@PropertySource("classpath:config/${spring.profiles.active}/dubbo.properties")
public class DubboConfig {


    //应用程序名称
    @Value("${application.name}")
    String APPLICATION_NAME;

    //注册中心地址
    @Value("${registry.address}")
    String REGISTRY_ADDRESS;

    //注册中心端口号
    @Value("${registry.port}")
    Integer REGISTRY_PORT;

    //消费超时时间
    @Value("${consumer.timeout}")
    Integer CONSUMER_TIMEOUT;

//    public static final String ANNOTATION_PACKAGE = "com.aishang.app.adapter";

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setPort(REGISTRY_PORT);
        return registryConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(CONSUMER_TIMEOUT);
        return consumerConfig;
    }
}
