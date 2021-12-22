package com.jacle.spboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JspApplication
{

    /**
     * 注意:不要直接启动该类,要以spring-boot:run命令方式启动才行,否则404!!!
     */
    public static void main(String[] args)
    {
        //必须通过spring-boot run的plugin方式来启动
        SpringApplication.run(JspApplication.class, args);
    }

}
