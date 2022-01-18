package com.jacle.spboot.httpmodule;

import com.jacle.spboot.httpmodule.exception.as.ResponseEnum;

/**
 * @author Jacle
 * @version 1.0
 * @description: 测试实例
 * @date 2022/1/17 17:53
 */
public class Test
{
    @org.junit.Test
    public void test1()
    {
        ResponseEnum.BAD_LICENCE_TYPE.assertNotNull(null);
    }

}
