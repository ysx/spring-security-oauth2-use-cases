package com.markix.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 等同于在 springmvc.xml 配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.markix.controller"
}, includeFilters = {
        //SpringMVC容器仅扫描 Controller组件
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
}, useDefaultFilters = false)
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {


}
