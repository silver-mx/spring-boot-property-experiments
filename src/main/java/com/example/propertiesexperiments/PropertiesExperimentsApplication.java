package com.example.propertiesexperiments;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class PropertiesExperimentsApplication {

    @Autowired
    private Environment env;

    @PostConstruct
    void contextLoads() {
        System.out.println("user.property=" + env.getProperty("user.property"));
        System.out.println("my.property=" + env.getProperty("my.property"));
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertiesExperimentsApplication.class, args);
    }

}
