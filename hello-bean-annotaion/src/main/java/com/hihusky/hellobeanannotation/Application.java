package com.hihusky.hellobeanannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        Greeting greeting;
        SecondGreeting secondGreeting;
        ThirdGreeting thirdGreeting;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("com.hihusky.helloannotation");
            context.refresh();
            greeting = context.getBean(Greeting.class);
            secondGreeting = context.getBean(SecondGreeting.class);
            thirdGreeting = context.getBean(ThirdGreeting.class);
        }
        System.out.println(greeting);
        System.out.println(secondGreeting);
        System.out.println(thirdGreeting);
    }
}
