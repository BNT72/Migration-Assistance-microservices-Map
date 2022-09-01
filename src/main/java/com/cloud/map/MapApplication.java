package com.cloud.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapApplication.class, args);
    }

}
