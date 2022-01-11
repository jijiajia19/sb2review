package com.jacle.spboot.validation.domain;

import javax.validation.Valid;
import java.util.*;

/**
 * @author Jacle
 * @version 1.0
 * @description: 验证的List
 * @date 2022/1/10 15:09
 */
//泛型一定要写在类之后，才能引用成功
public class ValidateList<T>
{
    //对象内部的对象是可以实现的
    @Valid
    public ArrayList<T> list = new ArrayList<T>();

}
