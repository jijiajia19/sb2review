package com.jacle.spboot.xmlssm.service;

import com.jacle.spboot.xmlssm.domain.Student;
import java.util.List;

public interface StudentService
{

    /**
     * 分页参数
     */
    List<Student> getAll(Integer pageNum, Integer pageSize);

    Student get(Integer id);

}
