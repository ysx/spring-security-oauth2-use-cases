package com.markix.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity(debug = true)//可不注解，注解只是为了方便调试
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略验证
        web.ignoring()
                .antMatchers("/test")
        ;
    }

    /* 不通过此方式设置无需验证的接口，该方式并不是完全忽略校验，当请求携带请求头'Authorization'时，还是会做校验！
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test").permitAll()
                .anyRequest().authenticated();
    }*/

}
