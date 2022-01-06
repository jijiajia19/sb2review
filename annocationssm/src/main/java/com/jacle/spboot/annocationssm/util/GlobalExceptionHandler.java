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
    //使用 @ControllerAdvice + @ExceptionHandler 进行全局的 Controller 层异常处理，只要设计得当，就再也不用在 Controller 层进行 try-catch 了！而且，@Validated 校验器注解的异常，也可以一起处理，无需手动判断绑定校验结果 BindingResult/Errors 了
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
