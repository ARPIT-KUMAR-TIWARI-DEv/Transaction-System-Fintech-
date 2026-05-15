package com.arpit.pfms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing   // Important for audit fields (createdAt, updatedAt)
public class PfmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfmsApplication.class, args);
    }
}