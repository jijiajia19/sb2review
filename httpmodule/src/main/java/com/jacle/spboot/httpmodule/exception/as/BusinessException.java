package com.jacle.spboot.httpmodule.exception.as;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jacle
 * @version 1.0
 * @description: 异常封装
 * @date 2022/1/17 15:52
 */
@Slf4j
//使用BaseException的作用就是，复用父类的输出，不需要根据每个子类，单独编写class
public class BusinessException extends BaseException
{
    public BusinessException(IResponseEnum ires, Object[] args, String message)
    {
       super(ires,args,message);
    }

    public BusinessException(IResponseEnum ires, Object[] args, String message,Throwable t)
    {
        super(ires, args, message, t);
    }
}
