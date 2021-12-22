package com.jacle.spboot.domain;

/**
 * @author Jacle
 * @version 1.0
 * @description: 结果响应消息体
 * @date 2021/12/22 15:24
 */
public class Message
{
    private int code;
    private String desc;

    public Message(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
