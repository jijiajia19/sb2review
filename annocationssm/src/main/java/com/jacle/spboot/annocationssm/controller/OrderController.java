package com.jacle.spboot.annocationssm.controller;

import com.jacle.spboot.annocationssm.domain.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jacle
 * @version 1.0
 * @description: Order Controller
 * @date 2021/12/28 15:16
 */

@Slf4j
@RestController
public class OrderController
{
    @GetMapping(value = "/order")
    //全局设置通过Long转换为Date类型
    public String order(@Valid OrderForm form, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        log.warn("order={}", form.toString());
        return "success";
    }

}
