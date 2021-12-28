package com.jacle.spboot.annocationssm.service;

import com.jacle.spboot.annocationssm.util.MyPropertyEditorSupport;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 全局的BindData处理类
 * @date 2021/12/28 13:33
 */
public class CustomDateWebBindingInitializer implements WebBindingInitializer
{
    @Override
    public void initBinder(WebDataBinder binder)
    {
        //绑定处理类型，处理执行类
        binder.registerCustomEditor(Date.class, new MyPropertyEditorSupport());
    }
}
