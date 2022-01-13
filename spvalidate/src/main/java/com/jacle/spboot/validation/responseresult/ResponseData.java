package com.jacle.spboot.validation.responseresult;

import java.io.Serializable;

/**
 * @author Jacle
 * @version 1.0
 * @description: 返回结果描述
 * @date 2022/1/12 10:26
 */
public class ResponseData<T> implements Serializable
{
    private String code;
    private String msg;
    private T data;

    public ResponseData(String code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(String code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(ResultEnums resultEnums)
    {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
    }

    public ResponseData(ResultEnums resultEnums, T data)
    {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
    }

    public ResponseData()
    {
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}