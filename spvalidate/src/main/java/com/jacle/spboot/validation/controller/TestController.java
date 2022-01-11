package com.jacle.spboot.validation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacle.spboot.validation.domain.*;
import com.jacle.spboot.validation.exception.ParamaErrorException;
import com.jacle.spboot.validation.exception.ResponseResult;
import com.jacle.spboot.validation.exception.ResultEnum;
import com.jacle.spboot.validation.service.ValidatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class TestController
{
    @Autowired
    private ValidatorService validatorService;

    /**
     * 获取用户信息
     *
     * @param username 姓名
     * @return ResponseResult
     */
    @Validated
    //produces不要多用，易出现，时灵时不灵的情况
    @GetMapping(value = "/userv1")
    @ResponseBody
    public ResponseResult findUserInfo(@RequestParam String username)
    {
        if (username == null || "".equals(username))
        {
            throw new ParamaErrorException("username 不能为空");
        } else
        {
            //此时会抛出异常
            //主要在controller里面抛出的异常，全局异常处理器，都会捕捉到
            validatorService.show("16");
        }
        return new ResponseResult(ResultEnum.SUCCESS);
    }


    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return ResponseResult
     */
    @PostMapping(value = "/userPost")
    @ResponseBody
    //嵌套对象的输入，多采用json的形式输入
//    public ResponseResult addUserInfo(@Validated(value = {User.Init.class}) @RequestBody User user)
    public ResponseResult addUserInfo(@Validated(value = {User.Second.class}) @RequestBody User user)
    {
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    @PostMapping(value = "/animalPost")
    @ResponseBody
    //嵌套对象的输入，多采用json的形式输入
//    public ResponseResult addUserInfo(@Validated(value = {User.Init.class}) @RequestBody User user)
    public ResponseResult animalInfo(@Validated @RequestBody Animal animal)
    {
        return new ResponseResult(ResultEnum.SUCCESS);
    }


    @PostMapping(value = "/listAnimalPost")
    @ResponseBody
    //嵌套对象的输入，多采用json的形式输入
//    public ResponseResult addUserInfo(@Validated(value = {User.Init.class}) @RequestBody User user)
    //参数直接是list，不验证内部的Animal
//    public ResponseResult listInfo(@Validated @RequestBody List<Animal> animals)
    public ResponseResult listInfo(@Validated @RequestBody ValidateList<Animal> animals)
    {
        return new ResponseResult(ResultEnum.SUCCESS);
    }


    @GetMapping(value = "/student")
    @ResponseBody
    //直接在controller里面处理的时候，使用bindingResult
    //使用ExceptionHandler注解捕获异常，这样代码中就不用声明BindingResult
    //参数校验
    //1:Validator + BindResult进行校验
    //2:Validator + 自动抛出异常
    public ResponseResult saveStu(@Validated(Student.CHECK.class) Student stu)
    {
        Map<String, String> map = new HashMap<>();
        //bindingresult就是获取message的地方
    /*    if (bindingResult.getErrorCount()>0)
        {
            bindingResult.getAllErrors().forEach(item ->
            {
                map.put(item.getCode(), item.getDefaultMessage());
            });
        }*/
        try
        {
            return new ResponseResult(1234, new ObjectMapper().writeValueAsString(map));
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
            return null;
        }
//        log.info(br.getErrorCount()+"");
//        return new ResponseResult(ResultEnum.SUCCESS);
    }

    @GetMapping(value = "/unitcaller")
    @ResponseBody
    public ResponseResult unitCaller(@Validated Unit unit)
    {
        return new ResponseResult(ResultEnum.SUCCESS);
    }
}