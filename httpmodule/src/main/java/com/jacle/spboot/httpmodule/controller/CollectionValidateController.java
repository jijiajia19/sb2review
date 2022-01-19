package com.jacle.spboot.httpmodule.controller;

import com.jacle.spboot.httpmodule.async.AsyncCase;
import com.jacle.spboot.httpmodule.domain.ListWrapper;
import com.jacle.spboot.httpmodule.domain.Unitv;
import com.jacle.spboot.httpmodule.exception.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Jacle
 * @version 1.0
 * @description: 参数是集合的校验控制器
 * @date 2022/1/14 14:01
 */

@Controller
@Slf4j
@Validated
public class CollectionValidateController
{
    //异步一定要从容器中获取对象，不能使用new
    @Autowired
    private AsyncCase asyncCase;

    @PostMapping("/getcollectionlist")
    @ResponseBody
    public ResponseResult callByCollectionParam(@Validated @RequestBody ListWrapper<Unitv> list) throws Exception
    {
        //必须要加requestbody才能获取到list集合的数值
        log.info("{}", list);

        asyncCase.doTask("1");
        asyncCase.doTaskTwo();

        TimeUnit.SECONDS.sleep(15);
        return new ResponseResult(200, "访问成功:" + Arrays.asList(list));
    }

    //@validate+@valid两种方式验证--有效
    @PostMapping("/getcollectionlist2")
    @ResponseBody
    public ResponseResult callByCollectionParam2(@Valid @RequestBody List<Unitv> list)
    {
        //必须要加requestbody才能获取到list集合的数值
        log.info("2:{}", list);
        return new ResponseResult(200, "访问成功2:" + Arrays.asList(list));
    }
}
