package com.hihusky;

public class SimpleCalculator implements Calculator {

    @Override
    public int add(int a, int b) {
        System.out.println("Executing add() method");
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Executing subtract() method");
        return a-b;
    }
}
