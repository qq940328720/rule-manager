package com.aishang.rulemanager.assembly.config;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import com.aishang.rulemanager.assembly.config.db.DataSourceConfig;
import com.aishang.rulemanager.assembly.config.dubbo.DubboConfig;
import com.aishang.rulemanager.assembly.config.mvc.AppSessionListener;
import com.aishang.rulemanager.assembly.config.mvc.AppWebConfiguration;
import com.aishang.rulemanager.assembly.config.redis.RedisConfig;
import com.aishang.rulemanager.assembly.config.security.SecurityConfig;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Created by neeke on 17-9-4.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{DataSourceConfig.class, DubboConfig.class, SecurityConfig.class};
        return new Class[]{DataSourceConfig.class, RedisConfig.class, SecurityConfig.class, DubboConfig.class};
//        return new Class[]{DataSourceConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppWebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
//
//    @Override
//    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
//
//        DispatcherServlet ds = new DispatcherServlet(servletAppContext);
//        ds.setThrowExceptionIfNoHandlerFound(true);
//        return ds;
//    }

    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistration.Dynamic webStatServlet = servletContext.addFilter("druidWebStatFilter", webStatFilter);
        webStatServlet.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        webStatServlet.addMappingForUrlPatterns(null, true, "/*");

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic encodingServlet = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingServlet.addMappingForUrlPatterns(null, true, "/*");

        return super.registerServletFilter(servletContext, filter);
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic druidStatViewServlet = servletContext.addServlet("druidStatView", new StatViewServlet());
        druidStatViewServlet.addMapping("/druid/*");
        ServletRegistration.Dynamic viewStatusMessagesServlet = servletContext.addServlet("viewStatusMessagesServlet", new ViewStatusMessagesServlet());
        viewStatusMessagesServlet.addMapping("/logback/*");
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        super.registerDispatcherServlet(servletContext);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new AppSessionListener());
    }

    /**
     * 把异常抛出去,交给GlobalExceptionController处理
     *
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}
