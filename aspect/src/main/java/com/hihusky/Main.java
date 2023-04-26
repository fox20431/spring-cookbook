package com.hihusky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Calculator calculator = context.getBean(Calculator.class);

        int result1 = calculator.add(2, 3);
        System.out.println("Result of add() method: " + result1);

        int result2 = calculator.subtract(5, 3);
        System.out.println("Result of subtract() method: " + result2);
    }
}