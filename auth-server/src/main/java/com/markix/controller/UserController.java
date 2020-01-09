package com.markix.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class UserController {
    @Autowired
    TokenEndpoint endpoint;
    @Autowired
    private ConsumerTokenServices tokenServices;


    private String client_id = "pwd_client";
    private String client_secret = "123456";
    private String grant_type = "password";
    private String scope = "server";

    private Principal principal = new Authentication() {
        @Override
        public String getName() {
            return client_id;
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return new ArrayList<GrantedAuthority>();
        }
        @Override
        public Object getCredentials() {
            return null;
        }
        @Override
        public Object getDetails() {
            return null;
        }
        @Override
        public Object getPrincipal() {
            return null;
        }
        @Override
        public boolean isAuthenticated() {
            return true;
        }
        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        }
    };

    /**
     * 获取当前登录用户
     */
    @GetMapping("/user/current")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    /**
     * 登录
     */
    @PostMapping("/user/login")
    public ResponseEntity<OAuth2AccessToken> login(String username, String password) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", grant_type);
        parameters.put("scope", scope);
        parameters.put("client_id", client_id);
        parameters.put("client_secret", client_secret);
        parameters.put("username", username);
        parameters.put("password", password);
        try {
            return endpoint.postAccessToken(principal, parameters);
        } catch (HttpRequestMethodNotSupportedException e) {
            log.error(e.getMethod(), e);
        }
        return null;
    }

    /**
     * 登出
     */
    @RequestMapping("/user/logout")
    public Object logout(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            tokenServices.revokeToken(tokenId);
        }
        return "success";
    }


    //测试
    @RequestMapping("/test")
    public Object test(){
        return "test";
    }


}
