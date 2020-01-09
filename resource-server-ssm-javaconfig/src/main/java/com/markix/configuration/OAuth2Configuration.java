//package com.markix.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//
///**
// * 这是一个替代方案，
// * 将OAuth2ResourceServerConfiguration和WebSecurityConfiguration两个配置类写在一起，统一管理。
// */
//@Configuration
//public class OAuth2Configuration {
//
//    /**
//     * spring-security-oauth2 配置
//     */
//    @Configuration
//    @EnableResourceServer
//    public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//        @Bean
//        public RemoteTokenServices remoteTokenServices(){
//            RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//            remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9010/oauth/check_token");
//            remoteTokenServices.setClientId("client");
//            remoteTokenServices.setClientSecret("123456");
//            return remoteTokenServices;
//        }
//
//    }
//
//
//    /**
//     * spring-security 配置
//     */
//    @Configuration
//    @EnableWebSecurity//(debug = true)
//    public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            //忽略验证
//            web.ignoring()
//                    .antMatchers("/test")
//            ;
//        }
//
//    /* 不通过此方式设置无需验证的接口，该方式并不是完全忽略校验，当请求携带token信息时还是会做校验！
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/test").permitAll()
//                .anyRequest().authenticated();
//    }*/
//
//    }
//
//
//
//}
