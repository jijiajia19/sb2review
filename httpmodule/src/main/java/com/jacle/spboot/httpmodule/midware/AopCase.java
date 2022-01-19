package com.jacle.spboot.httpmodule.midware;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author Jacle
 * @version 1.0
 * @description: 切面拦截器
 * @date 2022/1/19 9:06
 */
//切面拦截器测试示例
@Component
@Aspect
@Slf4j
public class AopCase
{
    //设置切点、前置、后置通知
  /*  @Pointcut("execution(public * com.jacle.spboot.httpmodule.controller.*.*(..))")
    public void doSome()
    {
    }*/

/*    @After(value = "doSome()")
    public void after(JoinPoint jp)
    {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束...");
    }

    // 异常通知
    @AfterThrowing(value = "doSome()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e)
    {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
    }


    //切面是方法层面的拦截器，能够获取方法的输入参数
    @Before("doSome()")
    public void before(JoinPoint joinPoint) throws Throwable
    {
        Object[] objs = joinPoint.getArgs();
        log.info("---->objs:{}", objs);
        for (Object obj : objs)
        {
            ListWrapper<Unitv> list = (ListWrapper<Unitv>) obj;
            List<Unitv> listuniv = list.getList();

            for (Unitv u : listuniv)
            {
                log.info("#{}", u);
                Unitv unitv = u;
                log.info("前置通知接受的参数:" + unitv);
                log.info("name:{}", unitv.getName());
                String name = base64EnStr(unitv.getName());
                unitv.setName(name);
            }

        }
    }

    //获取方法的返回结果
    @AfterReturning(returning = "object", pointcut = "doSome()")
    public void doAfterReturning(Object object)
    {
        String resultBody = (String) object;
//                .toString();
        String str = null;
        try
        {
            str = base64EnStr(resultBody);
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        log.info(str);
        log.info("前置通知响应的参数:" + resultBody);
    }*/

    //环绕通知
    //获取指定方法的输入参数和返回值
//    @Around("doSome()")
    @Around("execution(public * com.jacle.spboot.httpmodule.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();
        log.info("-->请求参数为{}", args);

        //动态修改其参数
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)

        //注意参数是数组还是变量
        Object result = joinPoint.proceed(args);
        log.info("-->响应结果为{}", result);

        //如果这里不返回result，则目标对象实际返回值会被置为null
        return result;
    }


    public String base64EnStr(String str) throws UnsupportedEncodingException
    {
        return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
    }


    public static String base64DeStr(String encodeStr) throws UnsupportedEncodingException
    {
        byte[] decodeStr = Base64.getDecoder().decode(encodeStr);
        return new String(decodeStr, "UTF-8");
    }
}
