package com.markix.configuration;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 等同于在 web.xml 配置
 * 用于动态添加 Filter、Listener、Servlet 等等
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //自动配置spring监听器、springmvc前端控制器
        super.onStartup(servletContext);

        // 添加spring-security必要的过滤器
        FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //该配置类等同于 spring.xml
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //该配置类等同于 springmvc.xml
        return new Class[]{SpringMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        //DispatcherServlet的映射路径
        return new String[]{"/"};
    }

}
