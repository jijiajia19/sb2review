package com.jacle.spboot.xmlssm.domain.mapper;

import com.jacle.spboot.xmlssm.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface StudentMapper
{
    List<Student> getAll();

    Student getById(@Param("id") int id);
}
