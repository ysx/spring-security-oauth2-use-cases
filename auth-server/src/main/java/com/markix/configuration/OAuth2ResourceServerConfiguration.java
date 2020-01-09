package com.markix.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 为什么需要此配置？
 * 因为提供了获取当前登录用户、登录、登出等接口（即为资源，详见{@link com.markix.controller.UserController}）,
 * 所以认证服务器也作为资源服务器。
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


}