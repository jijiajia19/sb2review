package com.jacle.spboot.httpmodule.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacle
 * @version 1.0
 * @description: List包装类
 * @date 2022/1/14 15:04
 */
@Data
public class ListWrapper<T>
{
    //内嵌对象的验证
    @Valid
    @Size(min = 1)
    private List<T> list;

    public ListWrapper()
    {
        list = new ArrayList<T>();
    }

    public ListWrapper(List<T> list)
    {
        this.list = list;
    }
}
