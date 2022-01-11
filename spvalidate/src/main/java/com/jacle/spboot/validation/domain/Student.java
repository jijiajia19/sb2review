package com.jacle.spboot.validation.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试scriptassert自定义验证方式
 * @date 2022/1/11 10:02
 */
//能够验证但是无法得到具体的错误提示
//验证复杂的需求
@ScriptAssert(lang = "javascript", groups = Student.CHECK.class,
        script = "com.jacle.spboot.validation.domain.Student.selfCheck(_this.name,_this.age,_this.classes)",message="复杂的验证")
@Data
@Slf4j
public class Student
{
    @NotBlank(groups = NAME.class)
    private String name;
    @Min(value = 19, groups = AGE.class
    )
    private int age;

    public interface NAME
    {
    }

    public interface AGE
    {
    }

    public interface CHECK
    {
    }

    public static boolean selfCheck(String name, int age, String classes)
    {
        log.info("assertscript开始验证...");
        if (name != null && age > 8 & classes != null)
        {
            log.info("年龄判断...");
            return true;
        } else
        {
            log.info("姓名判断...");
            return false;
        }
    }

}
