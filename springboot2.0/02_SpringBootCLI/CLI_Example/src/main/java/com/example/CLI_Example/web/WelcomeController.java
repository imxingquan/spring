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

package com.example.CLI_Example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 402059985@QQ.COM
 * @author
 * @date 2018/5/14
 */
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response,Model model){

        model.addAttribute("message","你好HelloWorld, 안녕하세요. ");
        return "index";
    }
}