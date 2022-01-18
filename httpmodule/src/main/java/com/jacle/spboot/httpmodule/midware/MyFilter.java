package com.jacle.spboot.httpmodule.midware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Jacle
 * @version 1.0
 * @description: 过滤器
 * @date 2022/1/18 16:39
 */
@Component
@Slf4j
//@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        log.info("time filter start class is {}", getClass());

        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("time filter:{}" + (System.currentTimeMillis() - start));
        log.info("time filter finish");
    }
}
