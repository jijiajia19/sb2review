package com.jacle.spboot.httpmodule.jsonconfig;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacle
 * @version 1.0
 * @description: 使用map作为属性的映射实体
 * @date 2021/12/31 14:05
 */
@Slf4j
@Data
@JsonPropertyOrder({"name", "properties"}) //指定属性的序列化顺序
@JsonRootName("root")
public class JsonMapDomain
{
//    @JsonIgnore
    private String name;

    private Map<String, String> properties;

    //通过map，来保存json，显示的时候并列显示
    @JsonAnyGetter
    public Map<String, String> getProperties()
    {
        return properties;
    }

    public JsonMapDomain(String name)
    {
        this.name = name;
        this.properties = new HashMap<String, String>();
    }


    @JsonAnySetter
    public void add(String key, String value)
    {
        this.properties.put(key, value);
    }
}
