package com.jacle.spboot.httpmodule.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Jacle
 * @version 1.0
 * @description: 全局异常处理器
 * @date 2022/1/7 11:08
 */
@Slf4j
//@ControllerAdvice
@RestControllerAdvice
//RespnseStatus通常跟全局Exception处理类放置在一起
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "系统繁忙，稍后访问")
public class GlobalErrorHandler
{
    @ExceptionHandler(Exception.class)
//    @ResponseBody
    public String prt()
    {
        log.error("异常抛出...");
        return "异常抛出...";
    }

    //每个controller都会执行的方法
    @InitBinder
    public void initb(WebDataBinder webDataBinder)
    {
        log.info("-->", webDataBinder);
        log.info("全局controller的webdatabinder");

    }

    //每次都会执行此方法，可以对对象进行封装，而后自动放置到response对象属性里
    //默认attribute是返回对象类型的小写名
    @ModelAttribute
    public String modelInit(Model model)
    {
        model.addAttribute("msg", "Hello World");

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 20);
        model.addAttribute("info", map);

        return "modelattr";
    }

    //指定user，没有返回值的方法
    @ModelAttribute
    public void test(@RequestParam("loginname") String loginname, @RequestParam("password") String password, Model model)
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", loginname);
        map.put("age", password);
        model.addAttribute("userWu", map);
    }
}
