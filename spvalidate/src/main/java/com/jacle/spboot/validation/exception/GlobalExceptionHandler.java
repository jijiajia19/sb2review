package com.jacle.spboot.validation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ModelAttribute
    public void prt()
    {
        //log.info("拦截器...");
    }

    /**
     * 忽略参数异常处理器
     *
     * @param e 忽略参数异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseResult parameterMissingExceptionHandler(MissingServletRequestParameterException e)
    {
        log.error("", e);
        return new ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(), "请求参数 " + e.getParameterName() + " 不能为空");
    }

    /**
     * 缺少请求体异常处理器
     *
     * @param e 缺少请求体异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e)
    {
        log.error("", e);
        return new ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(), "参数体不能为空");
    }

    /**
     * 参数效验异常处理器
     *
     * @param e 参数验证异常
     * @return ResponseInfo
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult parameterExceptionHandler(MethodArgumentNotValidException e)
    {
        log.error("", e);
        // 获取异常信息
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors())
        {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty())
            {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(), fieldError.getDefaultMessage());
            }
        }
        return new ResponseResult(ResultEnum.PARAMETER_ERROR);
    }

    /**
     * 自定义参数错误异常处理器
     *
     * @param e 自定义参数
     * @return ResponseInfo
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ParamaErrorException.class})
    public ResponseResult paramExceptionHandler(ParamaErrorException e)
    {
        log.error("" + e);
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (!StringUtils.isEmpty(e.getMessage()))
        {
            return new ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(), e.getMessage());
        }
        return new ResponseResult(ResultEnum.PARAMETER_ERROR);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResponseResult errorHandler(Exception e)
    {
//        log.error("" + getExceptionMsg(e));

        return new ResponseResult(ResultEnum.UNKNOWN_ERROR.getCode(),getExceptionMsg(e));
    }


    private String getExceptionMsg(Throwable t)
    {
        StringBuilder baseMsg = t.getMessage() != null ? new StringBuilder(t.getMessage()) : new StringBuilder(t.toString());
        if (t.getCause() != null)
        {
            if (t.getCause().getCause() != null)
            {
                if (t.getCause().getCause().getMessage() != null)
                {
                    baseMsg.append("\n").append(t.getCause().getCause().getMessage());
                }
            }
        }
        if (t.getStackTrace() != null && t.getStackTrace().length > 0)
        {
            StackTraceElement[] elements = t.getStackTrace();
            for (StackTraceElement element : elements)
            {
                if (element.getClassName().contains("com.jacle"))
                {
                    baseMsg.append("\n")
                            .append("className:").append(element.getClassName())
                            .append("\n").append("methodName:").append(element.getMethodName())
                            .append("\n").append("lineNumber:").append(element.getLineNumber());
                    break;
                }
            }
        }
        return baseMsg.toString();
    }
}