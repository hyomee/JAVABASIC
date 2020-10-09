package com.hyomee.example06;

public class UserMain {
    public static void main(String[] name) {
        User userA= new User("홍길동");  // 객체 생성
        userA.printNamePrint();

        User userB= new User("홍당무"); // 객체 생성
        userB.printNamePrint();

        System.out.println("#### Main 진입");
        new StaticInit();

        new Constructor();
     }
}

