package com.jacle.spboot.annocationssm.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jacle
 * @version 1.0
 * @description: 自定义层外错误处理类，处理404、500等返回码对应错误
 * @date 12/28/2021 11:44 PM
 */
@Controller
public class MyBaseErrorController implements ErrorController
{
    @RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request)
    {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                        + "<div>Exception Message: <b>%s</b></div><body></html>",
                statusCode, exception == null ? "N/A" : exception.getMessage());
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}
