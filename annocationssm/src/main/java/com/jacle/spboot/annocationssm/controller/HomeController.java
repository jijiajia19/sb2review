package com.jacle.spboot.annocationssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jacle
 * @version 1.0
 * @description: Home Controller
 * @date 2021/12/24 10:00
 */

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index(Model model)
    {
        //静态资源访问要加上前缀
        return "forward:res/home.html";
    }

    @GetMapping("/test")
    public String test(Model model)
    {
        //静态资源访问要加上前缀
        return "forward:res/test.html";
    }

}
