package com.viet.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableScheduling
public class SpringbootApplication {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
