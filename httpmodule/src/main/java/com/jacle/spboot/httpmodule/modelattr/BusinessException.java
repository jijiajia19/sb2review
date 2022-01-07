package com.jacle.spboot.httpmodule.modelattr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//自定义异常
@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "自定义异常!")
public class BusinessException extends RuntimeException
{

}