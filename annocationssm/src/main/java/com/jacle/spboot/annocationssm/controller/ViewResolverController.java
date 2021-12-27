package com.jacle.spboot.annocationssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jacle
 * @version 1.0
 * @description: View视图管理器
 * @date 2021/12/26 19:30
 */

@Slf4j
@Controller
public class ViewResolverController
{

    @GetMapping(value = "/showdiff/{type}")
    public String showView(@PathVariable("type") String type)
    {
        log.warn("type={}", type);
        return "跟一一哥学习ContentNegotiatingViewResolver!";
    }
}
