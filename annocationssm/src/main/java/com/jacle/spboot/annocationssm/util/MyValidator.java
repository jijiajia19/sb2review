package com.jacle.spboot.annocationssm.util;


import com.jacle.spboot.annocationssm.domain.TUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Jacle
 * @version 1.0
 * @description: 我的验证器
 * @date 2021/12/28 10:36
 */
@Component
public class MyValidator implements Validator
{
    //判断是否是父类，在validate方法中进行转换是先执行
    @Override
    public boolean supports(Class<?> aClass)
    {
        //isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
        return TUser.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        TUser t = (TUser) o;
        //配置字段验证信息
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Username is empty");

        //用户名长度不能小于5个字符
        if (t.getName().length() < 5)
        {
            errors.rejectValue("name", "", "Username length is less than 5");
        }

    }
}
