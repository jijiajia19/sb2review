package com.jacle.spboot.httpmodule.exception.as;

//枚举类和异常方法结合起来使用
//枚举集成异常接口
//断言封装异常检测，抛出
public enum ResponseEnum implements MyExceptionAssert
{

    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found.");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    private ResponseEnum(int i, String s)
    {
        this.code = i;
        this.message = s;
    }

    @Override
    public int getCode()
    {
        return code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
