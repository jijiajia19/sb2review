package com.jacle.spboot.httpmodule.exception.as;

/**
 * @author Jacle
 * @version 1.0
 * @description: 自定义Assert来处理异常
 * @date 2022/1/17 13:31
 */
//可以将Enum和Assert结合起来使用
public interface SelfAssert
{
    BaseException newException(Object... objects);

    BaseException newException(Throwable t, Object... objects);

    default void assertNotNull(Object object)
    {
        if(object==null)
        {
            throw newException(object);
        }
    }

    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }


}
