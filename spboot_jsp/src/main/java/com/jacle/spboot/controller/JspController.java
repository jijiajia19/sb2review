package com.jacle.spboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jacle
 * @version 1.0
 * @description: JSP web访问控制器
 * @date 2021/12/22 12:02
 */
@Controller
public class JspController
{
    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("msg", "SpringBoot combine JSP");
        //要跳转到的页面视图名称
        return "index";
    }
}
