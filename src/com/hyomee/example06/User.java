package com.hyomee.example06;

public class User {  // Class 정의
    private String name ;
    public User(String name) {
        this.name = name;
    }
    public void printNamePrint() {
        System.out.println(String.format("당신의 이름은 %s", this.name));
    }
}
