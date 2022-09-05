package com.example.springrecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRecapApplication.class, args);
    }

    @Bean
    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }

}
