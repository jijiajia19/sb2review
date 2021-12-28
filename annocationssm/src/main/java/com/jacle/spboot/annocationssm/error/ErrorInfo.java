package com.jacle.spboot.annocationssm.error;

import lombok.Data;

/**
 * @author Jacle
 * @version 1.0
 * @description: Error错误信息
 * @date 2021/12/28 17:57
 */

@Data
public class ErrorInfo<T>
{
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;

    private T data;
}
