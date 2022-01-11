package com.jacle.spboot.validation.service;

import com.jacle.spboot.validation.domain.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Jacle
 * @version 1.0
 * @description: Person验证器
 * @date 2022/1/9 18:55
 */
public class PersonValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return Person.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "名称不能为空!");

        Person p = (Person) o;
        if (p.getAge() < 0)
        {
            errors.rejectValue("age", "negative value", "年龄不能为负值");
        } else if (p.getAge() > 110)
        {
            errors.rejectValue("age", "too old", "年龄不能超过110");
        }

    }
}
