package com.jacle.spboot.httpmodule.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jacle
 * @version 1.0
 * @description: Exception处理类
 * @date 2022/1/6 14:37
 */
@Controller
public class InstanceExceptionController extends ExceptionHandlerClass
{
    //controller异常处理程序，只能处理controller，不能处理拦截器
    @RequestMapping("/testExp")
    @ResponseBody
    public String req(@RequestParam String param1)
    {
        JSONObject json = new JSONObject();
        json.put("status", "success");
        String str = null;

        return json.toString()+str.length();
    }

}
