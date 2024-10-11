package com.argus.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // JSP, Thymeleaf, Groovy, FreeMarker, Jade
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started on link > http://localhost:9000/dashboard");
    }
}