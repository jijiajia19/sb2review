package com.jacle.spboot.httpmodule.midware;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jacle
 * @version 1.0
 * @description: 拦截器实例
 * @date 2022/1/18 17:38
 */

@Configuration
public class InteceptorCase implements WebMvcConfigurer
{
    //springboot建立拦截器，通过Bean注解的方式
    @Bean
    public FilterRegistrationBean filterDemo3Registration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("myfilterCase");
        registration.setOrder(6);
        return registration;
    }

    //拦截器分为方法拦截器和类拦截器(HandlerInterceptor)


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new MyHandlerInterceptor());
    }
}
