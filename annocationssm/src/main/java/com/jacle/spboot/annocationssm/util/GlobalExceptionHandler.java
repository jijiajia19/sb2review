package com.jacle.spboot.annocationssm.util;

import com.jacle.spboot.annocationssm.error.CustomException;
import com.jacle.spboot.annocationssm.error.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jacle
 * @version 1.0
 * @description: 全局ExceptionHandler
 * @date 2021/12/28 18:00
 */

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception
    {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setMessage(e.getMessage());
        info.setCode(ErrorInfo.ERROR);
        info.setData("JSON格式异常处理信息");
        info.setUrl(req.getRequestURL().toString());
        return info;
    }
}
