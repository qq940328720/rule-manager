package com.aishang.rulemanager.assembly.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@PropertySource("classpath:config/${spring.profiles.active}/redis.properties")
@EnableCaching
public class RedisConfig {

    @Value("${redis.hostname}")
    private String hostName;
    @Value("${redis.port}")
    private int port;
    @Value("${cache.customer.expires}")
    private long customerExpires;
    @Value("${cache.employee.expires}")
    private long employeeExpires;
    @Value("${cache.reg.code.expires}")
    private long regCodeExpires;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(new RedisStandaloneConfiguration(hostName, port));
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(hostName);
        jedisConFactory.setPort(port);
        jedisConFactory.afterPropertiesSet();
        return jedisConFactory;
    }

    @Bean
    RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return stringRedisTemplate;
    }

    @Bean
    public CacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = RedisCacheManager.create(jedisConnectionFactory());
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
//        redisCacheManager.setDefaultExpiration(10);
//        Map<String, Long> expires = new HashMap<>();
//        expires.put(ASJFCacheConfig.CACHE_CUSTOMERS, customerExpires);
//        expires.put(ASJFCacheConfig.CACHE_EMPLOYEE, employeeExpires);

//        redisCacheManager.setExpires(ASJFCacheConfig.EXPIRES);
        return redisCacheManager;
    }
}
