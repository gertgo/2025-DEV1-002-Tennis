package com.bnp.tennis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bnp.tennis"})
public class TennisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }
}
