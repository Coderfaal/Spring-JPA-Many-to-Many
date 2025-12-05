package com.spring.jpa.JPA;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


@PropertySources(value= {
        @PropertySource("connection.properties"),
        @PropertySource("connection2.properties")

} )
//for common properties the last file has precedence
@SpringBootApplication

public class AddProperties implements CommandLineRunner {

    @Value("$(username")
    String username;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaMappingsApplication.class, args);
        Environment environment = context.getEnvironment();


        System.out.println(environment.getProperty("spring.application.name"));
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("username"));




    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(username);

    }
}
