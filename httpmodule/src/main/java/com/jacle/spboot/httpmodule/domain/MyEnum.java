package com.jacle.spboot.httpmodule.domain;

/**
 * @author Jacle
 * @version 1.0
 * @description:枚举类型
 * @date 2022/1/9 16:49
 */
public enum MyEnum
{
    //所有枚举都是隐式静态的，只是你不需要编写static关键字。与所有接口方法隐式公开的方式类似

    //枚举类型能够指定类型，在编译的时候能够检查，枚举变量是否在枚举数值之内
    //枚举能够遍历
    //枚举是一种类型，不同枚举类之间不能相互赋值，基于此在编译器内能够及时发现错误
    RED(1),GREEN(2),BLUE(3);

    //Enum是class，可以定义私有变量和构造方法
    //通过定义私有变量，从而获得更好的控制方法
    private int num;
    MyEnum(int n)
    {
        this.num=n;
    }

    public static void main(String[] args)
    {
        //name()返回常量名
        System.out.println(GREEN.name());
        System.out.println(GREEN==BLUE);
        //返回常量的顺序
        System.out.println(GREEN.ordinal());
        System.out.println(GREEN instanceof MyEnum);
    }
}
