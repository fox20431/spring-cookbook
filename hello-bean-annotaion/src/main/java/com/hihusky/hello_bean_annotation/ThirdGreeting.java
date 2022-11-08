package com.hihusky.hello_bean_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThirdGreeting {
    private String message;

    public ThirdGreeting(@Value("Hello again, Annotation!")String message) {
        this.message = message;
    }

    public ThirdGreeting() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ThirdGreeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
