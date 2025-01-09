package com.example.demoausprobieren;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoAusprobierenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoAusprobierenApplication.class, args);
    }
//   Damit kann man sehen, welche Beans alle initialisiert werden im ApplicationContext
    @Profile("profile")
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
