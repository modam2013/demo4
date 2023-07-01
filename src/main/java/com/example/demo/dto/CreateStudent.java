package com.example.demo.dto;

public class CreateStudent {
    private String name;
    private int age;

    public CreateStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public CreateStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
