package com.markix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceController {

    //测试
    @RequestMapping("/test")
    public Object test(){
        return "test";
    }

    //资源接口，访问时需要权限
    @RequestMapping("/resource")
    public Object resource(){
        return "resource";
    }

}
