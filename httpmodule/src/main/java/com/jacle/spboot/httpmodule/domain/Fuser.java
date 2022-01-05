package com.jacle.spboot.httpmodule.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jacle.spboot.httpmodule.jsonconfig.NullStringJsonSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试
 * @DateTimeFormat(pattern = "yyyy-MM-dd")
 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
 * @date 2021/12/31 13:17
 */
@Slf4j
@Data
//@JsonInclude(JsonInclude.Include.ALWAYS)  //NON_NULL:序列化时不会包含空值
public class Fuser
{
    //反序列化的时候不指定别名也可以成功执行
    @JsonProperty("fName1")
    @JsonSerialize(nullsUsing = NullStringJsonSerializer.class)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//shape指定json的类型
    @JsonSerialize(nullsUsing = NullStringJsonSerializer.class)
    private Date paramDate;

    public Fuser()
    {

    }

    //反序列化的时候，别名要通过@JsonAlias来处理

    //通过自定name的名称
//    @JsonCreator
/*    public Fuser(@JsonProperty("name") String name, @JsonProperty("paramDate") Date paramDate)
    {
        this.name = name;
        this.paramDate = paramDate;
    }*/


}
