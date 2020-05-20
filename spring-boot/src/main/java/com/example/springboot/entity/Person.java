package com.example.springboot.entity;

public class  Person {
    private String value;

    public Person(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}