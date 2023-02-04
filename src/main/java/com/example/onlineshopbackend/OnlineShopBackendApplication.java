package com.example.onlineshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnlineShopBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShopBackendApplication.class, args);
    }

}
