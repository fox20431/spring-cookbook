package com.hihusky.hellobean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Greeting greeting = context.getBean(Greeting.class);
        System.out.println(greeting);
    }
}
