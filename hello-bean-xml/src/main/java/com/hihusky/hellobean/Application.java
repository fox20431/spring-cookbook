package com.hihusky.hellobean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        Greeting greeting;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
            greeting = context.getBean(Greeting.class);
        }
        System.out.println(greeting);
    }
}
