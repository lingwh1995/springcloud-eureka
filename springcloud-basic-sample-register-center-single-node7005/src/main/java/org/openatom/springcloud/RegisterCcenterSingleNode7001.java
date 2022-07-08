package org.openatom.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class RegisterCcenterSingleNode7001 {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCcenterSingleNode7001.class,args);
    }
}