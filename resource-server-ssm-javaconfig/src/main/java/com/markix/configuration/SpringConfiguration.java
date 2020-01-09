package com.markix.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 等同于在 spring.xml 配置
 */
@Configuration
@ComponentScan(basePackages = {
        "com.markix"
}, excludeFilters = {
        //Spring容器中不扫描 Controller组件
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringMvcConfiguration.class)
})
public class SpringConfiguration {
}
