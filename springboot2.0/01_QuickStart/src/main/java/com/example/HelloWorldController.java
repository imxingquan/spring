/*
 * Copyright (c) 2017 , PANSOME All rights reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 402059985@QQ.COM
 * @author
 * @date 2018/5/14
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String getHello(){
        return "你好Spring";
    }

    @RequestMapping("/")
    public String index(){
        return "Home page";
    }
}
