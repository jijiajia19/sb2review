package com.jacle.spboot.spbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpbootadminApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpbootadminApplication.class, args);
    }

}
