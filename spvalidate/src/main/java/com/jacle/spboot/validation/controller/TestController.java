package com.jacle.spboot.validation.controller;

import com.jacle.spboot.validation.domain.Animal;
import com.jacle.spboot.validation.domain.User;
import com.jacle.spboot.validation.domain.ValidateList;
import com.jacle.spboot.validation.exception.ParamaErrorException;
import com.jacle.spboot.validation.exception.ResponseResult;
import com.jacle.spboot.validation.exception.ResultEnum;
import com.jacle.spboot.validation.service.ValidatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}