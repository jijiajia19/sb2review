package com.jacle.spboot.annocationssm.controller;

import com.jacle.spboot.annocationssm.domain.TUser;
import com.jacle.spboot.annocationssm.util.MyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacle
 * @version 1.0
 * @description: 数据Binder处理器
 * @date 2021/12/27 17:57
 */

@Slf4j
@RestController
public class ParamBinderController
{
    @Autowired
    private MyValidator myValidator;

    //只针对当前的Controller有效
    @InitBinder
    public void InitBinder(WebDataBinder binder)
    {
        binder.addValidators(myValidator);

        //前端传入的时间格式必须是"yyyy-MM-dd"效果!
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //设置为严格解析
        //setLenient用于设置Calendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
        df.setLenient(false);

        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @GetMapping(value = "/bind")
    public Map<String, Object> getFormatData(Date date) throws ParseException
    {
        log.warn("date={}", date);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jacle");
        map.put("age", 30);

        //默认的String不能直接转换为Date对象
        map.put("date", date);
        return map;
    }

    //@requestParam、@requestMapping是最原始的
    //多一项BindingResult
    @GetMapping(value = "/bindinguser")
//    @RequestParam(required = true) 不能用在对象上
    //@valid可以通过验证器来验证参数的有效性
    //@RequestBody用来post接收一个json，注入到指定的对象
    public String createUser(@Valid TUser user)
//            , BindingResult result)
    {
 /*       if (result.hasErrors())
        {
            log.info("--->",result.getFieldError().getDefaultMessage());
            return result.getFieldError().getDefaultMessage();
        }*/

        log.info(user.getName() + "," + user.getAge());
        return "success";
    }


}
