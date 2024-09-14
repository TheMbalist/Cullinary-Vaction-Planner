package com.example.cullinaryplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
@ComponentScan("com.example.cullinaryplanner")
@EntityScan("com.example.cullinaryplanner.model")
@EnableJpaRepositories(basePackages = "com.example.cullinaryplanner.repositories")

public class CullinaryplannerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CullinaryplannerApplication.class, args);
    }
}