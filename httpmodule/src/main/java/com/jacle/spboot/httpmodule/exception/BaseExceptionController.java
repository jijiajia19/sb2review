package com.jacle.spboot.httpmodule.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseExceptionController
{
    // 表示这是一个异常处理方法
    // value = Exception.class表示处理的异常类型为Exception
    // 也就是处理所有的异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) throws Exception
    {
        ModelAndView mav = new ModelAndView();
        // 设置模型数据
        //页面只能接收字符串，传递对象，显示不出来
        mav.addObject("ex", e);
        // 设置视图
        mav.setViewName("error");
        return mav;
    }
}