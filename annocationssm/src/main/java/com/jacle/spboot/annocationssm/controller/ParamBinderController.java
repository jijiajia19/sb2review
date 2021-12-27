package com.jacle.spboot.annocationssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
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
    @GetMapping(value = "/bind")
    public Map<String, Object> getFormatData(Date date) throws ParseException
    {
        log.warn("date={}", date);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jacle");
        map.put("age", 30);
        map.put("date", date);
        return map;
    }
}
