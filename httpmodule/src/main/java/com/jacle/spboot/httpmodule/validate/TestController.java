package com.jacle.spboot.httpmodule.validate;

import com.jacle.spboot.httpmodule.exception.ParamaErrorException;
import com.jacle.spboot.httpmodule.exception.ResponseResult;
import com.jacle.spboot.httpmodule.exception.ResultEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public class TestController
{

    /**
     * 获取用户信息
     *
     * @param username 姓名
     * @return ResponseResult
     */
    @Validated
    @GetMapping("/userv")
    public ResponseResult findUserInfo(@RequestParam String username)
    {
        if (username == null || "".equals(username))
        {
            throw new ParamaErrorException("username 不能为空");
        }
        return new ResponseResult(ResultEnum.SUCCESS);
    }


    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return ResponseResult
     */
    @PostMapping("/user")
    //嵌套对象的输入，多采用json的形式输入
    public ResponseResult addUserInfo(@Valid @RequestBody User user)
    {
        return new ResponseResult(ResultEnum.SUCCESS);
    }

}