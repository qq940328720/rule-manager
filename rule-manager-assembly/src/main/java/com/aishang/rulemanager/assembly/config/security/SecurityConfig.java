package com.aishang.rulemanager.assembly.config.security;


import com.aishang.rulemanager.assembly.config.security.handler.*;
import com.aishang.rulemanager.facade.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by neeke on 17-9-11.
 * Spring Security配置类
 */
@EnableWebSecurity
@ComponentScan
//@PropertySource("classpath:org/springframework/security/messages_zh_CN.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;
    @Autowired
    private RestAuthenticationLogoutHandler restAuthenticationLogoutHandler;
    /**
     * 接口访问权限规则
     */
    @Value("${security.accessExpressions}")
    private String accessExpressions;

    @Autowired
    private IAdminService adminService;

    /**
     * 配置身份认证器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //员工
//        auth.authenticationProvider(emplAuthenticationProvider());
//        //客户
        auth.userDetailsService(adminService).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .and().logout().logoutUrl("/logout")
                .and().logout().addLogoutHandler(restAuthenticationLogoutHandler)//退出登录
                .and()
                .csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and().authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers("/auth/**").permitAll()
                .antMatchers(
                        "/auth/**",
                        "/logout/**",
                        "/resources/**",
                        "/**/*.html",
                        "/swagger/**",
                        "/druid/**",
                        "/logback/**",
                        "/webjars/**",
                        "/v2/api-docs/**",
                        "/swagger-resources/**").permitAll()
                .anyRequest().access(accessExpressions)
//                .anyRequest().permitAll()
                .and()
                .headers().cacheControl().and()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .maximumSessions(1).maxSessionsPreventsLogin(true).and().sessionFixation().migrateSession();

    }
}
