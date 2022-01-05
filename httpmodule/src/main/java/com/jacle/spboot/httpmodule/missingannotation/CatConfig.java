package com.jacle.spboot.httpmodule.missingannotation;

import org.springframework.context.annotation.Bean;

//@Configuration
public class CatConfig {
    @Bean
   // @ConditionalOnMissingBean //如果容器有此Bean，不加载;
//    @ConditionalOnBean //只有当某个bean在容器中，才能执行bean的创建
    public Animal animal() {
        return new Cat();
    }
}