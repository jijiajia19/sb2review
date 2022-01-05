package com.jacle.spboot.httpmodule.modelattr;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jacle
 * @version 1.0
 * @description: ResponseStatus控制器
 * @date 2022/1/5 17:24
 */
@Controller
public class ResponseController
{
    @RequestMapping(value = "/helloResponseStatus")
    //直接注定方法的返回码，通常不这么用，通常用来指定对应的异常
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "404-NotFound")
    @ResponseBody
    public void helloResponseStatus(@RequestParam(value = "name") String name)
    {
        System.out.println("======");
    }

    @RequestMapping(value = "/helloResponseStatus2")
    public void helloResponseStatus2(@RequestParam(value = "name") String name)
    {
        if (StringUtils.isBlank(name))
        {
            throw new BusinessException();
        } else
        {
            throw new BusinessException();
        }
    }

}
