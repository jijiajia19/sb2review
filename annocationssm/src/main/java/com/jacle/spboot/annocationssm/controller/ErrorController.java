package com.jacle.spboot.annocationssm.controller;

import com.jacle.spboot.annocationssm.error.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jacle
 * @version 1.0
 * @description: 错误处理控制器
 * @date 2021/12/28 17:27
 */
//这种处理方式只对页面访问方式有效，接口访问方式无效
@Controller
public class ErrorController
{

    @ResponseBody
    @GetMapping("/sherr")
    public String showMsg()
    {
        return "success";
    }

    @GetMapping("/showError")
    public void showError()
    {
        throw new RuntimeException("自定义异常...");
    }

    @RequestMapping("/json")
    public String handleJsonException() throws CustomException
    {
        //对指定的异常信息，返回不同的显示方式
        //通过配置全局的ExceptionHandler
        throw new CustomException("json格式的异常处理方案...");
    }


}
