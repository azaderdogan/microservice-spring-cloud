package com.azaderdogan.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotficationService {
    public static void main(String[] args){
        SpringApplication.run(NotficationService.class,args);
    }

}
