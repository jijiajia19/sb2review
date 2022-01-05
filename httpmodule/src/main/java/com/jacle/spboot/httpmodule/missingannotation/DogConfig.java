package com.jacle.spboot.httpmodule.missingannotation;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {
//    @Bean
    public Animal animal() {
        return new Dog();
    }
}