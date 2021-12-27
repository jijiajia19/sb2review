package com.jacle.spboot.annocationssm.controller;

import com.jacle.spboot.annocationssm.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试json Controller后端处理类
 * @date 2021/12/23 17:50
 */

@Slf4j
@RestController
public class TestJsonController
{
    @GetMapping("/user/{salary}")
    public User home(@PathVariable("salary") Long salary)
    {
        return new User("一一哥", 30, true, new Date(), "程序员", salary);
    }

    /**
     * 将一个json转化为对象-->反序列化
     */
    @RequestMapping(value = "user")
    public String getValue(@RequestBody User user)
    {
        log.warn("user=" + user.toString());
        return user.toString();
    }

}
