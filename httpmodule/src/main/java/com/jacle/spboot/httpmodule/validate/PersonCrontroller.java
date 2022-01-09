package com.jacle.spboot.httpmodule.validate;

import com.jacle.spboot.httpmodule.validate.validator.PersonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public void savePerson(Person person)
    {
        log.info("请求参数：{}", person);


        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());
        binder.validate();

        // get BindingResult that includes any validation errors
        BindingResult results = binder.getBindingResult();
        log.info("results:{}", results);
    }
}
