package com.roma.jdk8.language;

public class Person {

    public enum Sex {
        BOY, GIRL
    }

    public Person(String name, Sex gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    private String name;
    private Sex gender;
    private Integer age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Sex getGender() {
        return gender;
    }
    public void setGender(Sex gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}