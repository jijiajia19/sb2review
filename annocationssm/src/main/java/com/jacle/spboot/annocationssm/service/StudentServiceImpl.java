package com.jacle.spboot.annocationssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacle.spboot.annocationssm.domain.Student;
import com.jacle.spboot.annocationssm.domain.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//调用Mapper的实现类进行业务逻辑组织
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAll(Integer pageNum, Integer pageSize) {
        //在查询之前设置分页,利用Mybatis的分页插件实现分页
        PageHelper.startPage(pageNum, pageSize);

        List<Student> list = studentMapper.getAll();
        PageInfo<Student> info = new PageInfo<>(list);
        return info.getList();
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.getById(id);
    }

}
