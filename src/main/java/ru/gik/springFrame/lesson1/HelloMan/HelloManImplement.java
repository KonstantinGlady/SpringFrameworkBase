package ru.gik.springFrame.lesson1.HelloMan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloManImplement implements HelloMan {
    @Value("Ivan")
    private String name;

    public HelloManImplement() {

    }

    public HelloManImplement(String name) {
        this.name = name;
    }

    public void helloSay() {
        System.out.println("Hello! " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
