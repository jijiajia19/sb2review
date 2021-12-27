package com.jacle.spboot.annocationssm.java8;

/**
 * @description: 默认接口的设定及使用场景
 * @author Jacle
 * @date 2021/12/27 15:07
 * @version 1.0
 */
public interface DefaultInter
{
    void add();
    void test();

    //作用：给接口新增方法，不需要重新修改所有的接口实现类
    default void put(){
        System.out.println("put the key in");
    }
    default void put2(){
        System.out.println("put the key in");
    }

}
