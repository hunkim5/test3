package com.airpremia.eosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EoshApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(EoshApiApplication.class, args);
    }
}
