package com.jacle.spboot.httpmodule.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

//处理页面的ExceptionHandler
@Controller
@Slf4j
public class UserController extends BaseExceptionController
{
    @GetMapping("/login")
    public String login(String username) throws Exception
    {
        log.info(username);
        if (username == null)
        {
            // 调用本类的异常处理方法
            throw new NullPointerException("用户名不存在!");
        } else if ("test".equals(username))
        {
            try
            {
                int i = 5 / 0;
                return "success";
            } catch (Exception e)
            {
                throw new SQLException("查找图书信息失败!");
            }
        }
        return "success";
    }
}