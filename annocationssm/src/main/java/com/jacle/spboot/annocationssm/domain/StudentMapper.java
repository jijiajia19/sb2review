package com.jacle.spboot.annocationssm.domain;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface StudentMapper
{
    @Select("SELECT * FROM student")
    List<Student> getAll();

    @Select("SELECT * FROM student where id=#{id}")
    Student getById(@Param("id") int id);
}
