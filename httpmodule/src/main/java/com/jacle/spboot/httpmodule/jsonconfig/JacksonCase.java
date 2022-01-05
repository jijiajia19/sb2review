package com.jacle.spboot.httpmodule.jsonconfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jacle.spboot.httpmodule.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Jacle
 * @version 1.0
 * @description: Jackson处理相关
 * @date 2021/12/31 10:55
 */

@Slf4j
public class JacksonCase
{

    public static void dateformatTip(String format)
    {
        log.info(new SimpleDateFormat(format).format(new Date()));
    }

    public static void main(String[] args) throws JsonProcessingException
    {
        //jackson序列化和反序列化
        //在Jackson中使用ObjectMapper对象来进行序列化和反序列化操作
        User u = User.buildOne();
        ObjectMapper jacksonMapper = new ObjectMapper();
        //localdatetime、localdate的序列化问题
        jacksonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        jacksonMapper.registerModule(new JavaTimeModule());

        //默认的json都是时间戳，Long类型
        String jsonStr = jacksonMapper.writeValueAsString(u);

        log.info(jsonStr);

        dateformatTip("YYYY-MM-dd");
        //应该使用小y
        dateformatTip("yyyy-MM-dd");

        //反序列化
        User deserialUser = jacksonMapper.readValue(jsonStr, User.class);
        log.info(deserialUser.getBirthday().toString());

        String listJacksonStr = jacksonMapper.writeValueAsString(Arrays.asList(User.buildOne(), User.buildOne()));
        log.info(listJacksonStr);
        List<User> userlist=jacksonMapper.readValue(listJacksonStr, new TypeReference<List<User>>()
        {
        });
        log.info(userlist.get(0).getBirthday().toString());

    }
}
