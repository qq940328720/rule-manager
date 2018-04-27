package com.aishang.rulemanager.assembly.config.db;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by neeke on 17-9-5.
 * 数据源配置类
 */
@EnableAsync
@Configuration
@EnableAspectJAutoProxy
@MapperScan(value = "com.aishang.rulemanager.dal.mapper", annotationClass = Mapper.class)
@PropertySources({
        @PropertySource("classpath:config/${spring.profiles.active}/db.properties"),
        @PropertySource("classpath:config/${spring.profiles.active}/security.properties")
})
@ComponentScans(
        value = {
                @ComponentScan("com.aishang.rulemanager.adapter"),
                @ComponentScan("com.aishang.rulemanager.client"),
                @ComponentScan("com.aishang.rulemanager.assembly.monitor"),
                @ComponentScan("com.aishang.rulemanager.sso"),
                @ComponentScan("com.aishang.rulemanager.common")
        })
@EnableCaching
@EnableTransactionManagement
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driverClassName}")
    String driverClassName;

    @Value("${spring.datasource.filters}")
    String filters;

    @Value("${spring.datasource.connectionProperties}")
    String connectionProperties;

    @Value("${spring.datasource.initialSize}")
    String initialSize;

    @Value("${spring.datasource.minIdle}")
    String minIdle;

    @Value("${spring.datasource.maxActive}")
    String maxActive;

    @Value("${spring.datasource.maxWait}")
    String maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    String timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    String minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    String testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    String testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    String testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    String poolPreparedStatements;

    @Value("${spring.datasource.maxOpenPreparedStatements}")
    String maxOpenPreparedStatements;

    private static String MAPPER_PATH = "/mapper/*.xml";


    /**
     * 初始化数据库连接池
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        LOGGER.info("初始化数据库连接池====开始");
        Map<String, Object> properties = new HashMap<>();
        properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, driverClassName);
        properties.put(DruidDataSourceFactory.PROP_URL, dbUrl);
        properties.put(DruidDataSourceFactory.PROP_USERNAME, userName);
        properties.put(DruidDataSourceFactory.PROP_PASSWORD, password);

        properties.put(DruidDataSourceFactory.PROP_INITIALSIZE, initialSize);
        properties.put(DruidDataSourceFactory.PROP_MINIDLE, minIdle);
        properties.put(DruidDataSourceFactory.PROP_MAXACTIVE, maxActive);
        properties.put(DruidDataSourceFactory.PROP_MAXWAIT, maxWait);
        properties.put(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS, timeBetweenEvictionRunsMillis);
        properties.put(DruidDataSourceFactory.PROP_MINEVICTABLEIDLETIMEMILLIS, minEvictableIdleTimeMillis);
        properties.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY, validationQuery);
        properties.put(DruidDataSourceFactory.PROP_TESTWHILEIDLE, testWhileIdle);
        properties.put(DruidDataSourceFactory.PROP_TESTONBORROW, testOnBorrow);
        properties.put(DruidDataSourceFactory.PROP_TESTONRETURN, testOnReturn);
        properties.put(DruidDataSourceFactory.PROP_POOLPREPAREDSTATEMENTS, poolPreparedStatements);
        properties.put(DruidDataSourceFactory.PROP_MAXOPENPREPAREDSTATEMENTS, maxOpenPreparedStatements);
        //添加统计、SQL注入、日志过滤器
        properties.put(DruidDataSourceFactory.PROP_FILTERS, filters);
        //sql合并，慢查询定义为5s
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES, connectionProperties);
        LOGGER.info("初始化数据库连接池====结束");
        return DruidDataSourceFactory.createDataSource(properties);
    }


    /**
     * 初始化事务管理
     *
     * @return
     * @throws Exception
     */
    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 初始化SqlSessionFactoryBean
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        LOGGER.info("初始化SqlSessionFactoryBean====开始");
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.aishang.rulemanager.dal.model");
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
        sessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        LOGGER.info("初始化SqlSessionFactoryBean====结束");
        return sessionFactory;
    }
}
