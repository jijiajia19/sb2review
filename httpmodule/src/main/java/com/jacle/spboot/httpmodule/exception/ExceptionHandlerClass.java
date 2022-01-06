package com.jacle.spboot.httpmodule.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jacle
 * @version 1.0
 * @description: 第一种方式:使用基类进行异常处理的方式
 * @date 2022/1/6 11:56
 */
public abstract class ExceptionHandlerClass
{
    //处理请求异常，返回一个response代替原来的响应处理事件
    @ExceptionHandler
    public @ResponseBody  String handleException(HttpServletRequest request, HttpServletResponse
            response, RuntimeException ex)
    {
        JSONObject json = new JSONObject();
        json.put("isError", true);
        json.put("msg", ex.getMessage());

        System.out.println(json);
        return json.toString();
    }
}
