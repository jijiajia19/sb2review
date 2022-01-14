package com.jacle.spboot.validation.controller;

import com.jacle.spboot.validation.domain.Person;
import com.jacle.spboot.validation.service.PersonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jacle
 * @version 1.0
 * @description: 参数验证
 * @date 2022/1/9 20:20
 */
@Slf4j
@Controller
public class PersonCrontroller
{
    @GetMapping("/personvalidate")
    @ResponseBody
    public BindingResult savePerson(Person person)
    {
        log.info("请求参数：{}", person);

        //通过此进行异常抛出替代，也能在后端被补货
        Assert.notNull(person,"用户不存在");

        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());

        //自己设定的验证器，并没有触发全局异常
        binder.validate();

        // get BindingResult that includes any validation errors
        BindingResult results = binder.getBindingResult();
        log.info("results:{}", results);

        return results;
    }
}
