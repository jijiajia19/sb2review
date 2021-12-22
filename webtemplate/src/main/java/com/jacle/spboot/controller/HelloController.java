package com.jacle.spboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 控制器
 */
@Controller
public class HelloController
{

    @GetMapping("/hello")
    public String hello(ModelMap map)
    {
        map.addAttribute("hello", "测试leaf模板");

        return "hello";
    }

}
