package com.marondal.springexample.lifecycle;

public class Person {

    // 이름, 나이
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "이름 : " + name + " 나이 : " + age;
    }

}
