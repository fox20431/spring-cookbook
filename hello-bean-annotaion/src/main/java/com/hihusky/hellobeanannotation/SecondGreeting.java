package com.hihusky.hellobeanannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecondGreeting {
    private String message;

    public SecondGreeting() {
    }

    public SecondGreeting(@Value("Hello again, Annotation!")String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SecondGreeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
