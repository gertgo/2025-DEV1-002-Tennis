package com.bnp.tennis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.bnp.tennis"})
@EnableJpaRepositories(basePackages = "com.bnp.tennis.repository.client")
@EntityScan(basePackages = "com.bnp.tennis.repository.model")
public class TennisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }
}
