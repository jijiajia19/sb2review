package com.jacle.spboot.validation.validator;

import com.jacle.spboot.validation.domain.Unit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jacle
 * @version 1.0
 * @description: 年龄校验器
 * @date 2022/1/11 13:10
 */
public class CheckAgeImpl implements ConstraintValidator<CheckAgeValidator, Unit>
{

    @Override
    public void initialize(CheckAgeValidator constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(Unit unit, ConstraintValidatorContext constraintValidatorContext)
    {
        //实际校验字段内容逻辑
        if ("test".equals(unit.getName()))
        {
            if (unit.getAge() < 19)
            {
                return false;
            }
        }
        return true;
    }
}
