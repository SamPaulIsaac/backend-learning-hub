package com.sam.actuatorAndSwagger;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class ActuatorAndSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorAndSwaggerApplication.class, args);
    }
}

