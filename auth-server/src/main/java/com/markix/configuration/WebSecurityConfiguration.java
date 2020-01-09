package com.markix.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity(debug = true)//可不注解，注解只是为了方便调试
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 暂时使用内存来存储用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        String password = passwordEncoder().encode("123456");
        manager.createUser(User.builder().username("admin").password(password).roles("USER").build());
        manager.createUser(User.builder().username("user").password(password).roles("USER").build());
        return manager;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //覆盖默认配置，去掉security自带的form登录表单
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略验证
        web.ignoring()
                .antMatchers("/user/login")
                .antMatchers("/test")
        ;
    }
}
