package com.jacle.spboot.httpmodule.paramhandler;

import com.jacle.spboot.httpmodule.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Jacle
 * @version 1.0
 * @description: 参数处理控制类
 * @date 2022/1/6 13:04
 */

@Controller
@Slf4j
public class ParamController
{
    @PostMapping(value = "/postJson",consumes = "application/json",produces = "application/json;charset=UTF-8")
    @ResponseBody
//    public String getUrlByPhoneNumber(@RequestBody String json, HttpServletRequest request)
    public User getUrlByPhoneNumber(@RequestBody User jsonUser, HttpServletRequest request)
    {
        //requestbody表示发送的是json字符串
        log.info(jsonUser.toString());
        return jsonUser;
    }

    //通过Map来接收Json参数
    @PostMapping(value = "/postJMap",produces = "application/json;charset=UTF-8")
    @ResponseBody
//    public String getUrlByPhoneNumber(@RequestBody String json, HttpServletRequest request)
    public String getUrlByPhoneNumberByMap(@RequestBody Map params)
    {
        System.out.println(params);
        //requestbody表示发送的是json字符串
        log.info(params.get("birthday").toString());
        return params.get("birthday").toString();
    }

    //通过List来接收Json参数
    @PostMapping(value = "/postJList",produces = "application/json;charset=UTF-8")
//    public String getUrlByPhoneNumber(@RequestBody String json, HttpServletRequest request)
    public @ResponseBody String getUrlByPhoneNumberByMap(@RequestBody List<User> params)
    {
        System.out.println(params);
        //requestbody表示发送的是json字符串
        log.info(params.toString());
        return params.toString();
    }
}
