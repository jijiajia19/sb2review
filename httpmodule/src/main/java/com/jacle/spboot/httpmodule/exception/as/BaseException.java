package com.jacle.spboot.httpmodule.exception.as;

/**
 * @author Jacle
 * @version 1.0
 * @description:基类，输出类
 * @date 2022/1/17 17:27
 */
public class BaseException extends RuntimeException
{
    public BaseException(IResponseEnum responseEnum, Object[] args, String message)
    {
        System.out.println(message);

    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause)
    {
        System.out.println(message);
    }


}
