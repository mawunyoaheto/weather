package com.raymond.practice.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherapiApplication {

    public static void main(String[] args) {
        System.out.println("Start...");
        SpringApplication.run(WeatherapiApplication.class, args);
        System.out.println("End...");
    }

}
