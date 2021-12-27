package com.jacle.spboot.annocationssm.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jacle.spboot.annocationssm.json.StudentJson;

public class Student
{
    private Integer id;

    private String name;

    private String sex;


    public Student()
    {

    }

    //反序列化的时候通过此构造函数处理
    @JsonCreator
    public Student(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("sex") String sex)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @JsonSerialize(using = StudentJson.MySerialer.class)
    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

}