package com.jacle.spboot.httpmodule.modelattr;

import org.springframework.web.bind.annotation.ResponseStatus;

//自定义异常
@ResponseStatus(reason = "The system is exception！")
public class BusinessException extends RuntimeException
{
}