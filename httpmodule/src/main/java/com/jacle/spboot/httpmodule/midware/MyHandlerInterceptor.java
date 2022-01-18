package com.jacle.spboot.httpmodule.midware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jacle
 * @version 1.0
 * @description: 拦截器, 拦截的是http请求
 * @date 2022/1/18 17:42
 */
@Component
@Slf4j
public class MyHandlerInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        log.info(((HandlerMethod) handler).getBean().getClass().getName());
        log.info(((HandlerMethod) handler).getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        log.info("postHandle");
        Long start = (Long) request.getAttribute("startTime");

        log.info("time interceptor 耗时：{}", (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        log.info("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");

        log.info("time interceptor 耗时{}", (System.currentTimeMillis() - start));
    }
}
