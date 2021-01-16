package com.azaderdogan.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients//bu şekilde implemente edilen tüm projelerde kullanılacak. Tüm clientler için ortak enable ettitk
public class FeignConfig {
}
