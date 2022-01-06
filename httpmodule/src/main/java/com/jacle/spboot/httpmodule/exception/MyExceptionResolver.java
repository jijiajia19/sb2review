package com.jacle.spboot.httpmodule.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacle
 * @version 1.0
 * @description: 全局异常处理类
 * @date 2022/1/6 15:32
 */
@Configuration
@Slf4j
public class MyExceptionResolver
{
    @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver()
    {
        //返回匿名内部类，此时只需要知道参数和方法即可
        //能够使用lambda的接口，内部准能有一个抽象方法，但是可以使用注解进行强制规范
    /*    return (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) ->
        {
            System.out.println("发生全局异常!");
            ModelMap mmp = new ModelMap();
            mmp.addAttribute("ex", "resolver:"+ex.getMessage());
            return new ModelAndView("error", mmp);
        };*/

        //返回json的全局异常处理类
        return (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) ->
        {
            log.info("发生全局异常，type:JSON!");
            ModelMap mmp = new ModelMap();
            mmp.addAttribute("ex", ex.getMessage());
            response.addHeader("Content-Type", "application/json;charset=UTF-8");

            log.info("启动了全局异常处理，返回JSON格式");
            try
            {
//                new ObjectMapper().writeValue(response.getWriter(), ex.getMessage());
//                response.getWriter().flush();

                //通过writer直接写到响应对象，此时不用加双引号
                //结论：当@ResponseBody返回时，会自动给返回值json化。当为对象时返回 ｛“name” : “val”, “name2” : “val2”} 。但是当返回值为string类型时会被解析成为“xxx”。
                //
                //解决方案：使用HttpServletResponse返回输出到流中。
                response.getWriter().println(ex.getMessage());
                response.getWriter().flush();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return new ModelAndView();
        };
    }
}
