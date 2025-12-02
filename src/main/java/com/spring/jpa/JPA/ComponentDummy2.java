package com.spring.jpa.JPA;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ComponentDummy2 {
    @Autowired
    Environment env;

    @Value("${db_password}")
    String dbp;

    public ComponentDummy2() {
    }

    @PostConstruct
    public void method2(){
        System.out.println(env.getProperty("JAVA_HOME"));
        System.out.println(dbp);
}}
