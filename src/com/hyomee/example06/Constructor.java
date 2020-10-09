package com.hyomee.example06;

public class Constructor extends Object {
    String name ;  // 인스턴스 변수

    // 기본 생성자
    public Constructor() {
        // System.out.println("#### Constructor 기본 생성자 "); -> 주석을 풀면 오류 발생
        this("홀길동");   // 다른 생성자 호출
        this.name = "김길자";

        // 1. 다른 생성자 호출 ( 자기 자신의 또 다른 생성자 ) -> super(), this()
        // 2. super(), this() 를 이용한 다른 생성자 호출 시는 생성자의 첫 문자에 나타내야 한다.
        //    -> 컴파일 시점 오류 : java: call to super must be first statement in constructor
        //    -> super()을 사용해서 상위 클래스를 호출 하려면 this()에 의헤서 자기 자신 생성자를 호출
        //       하였을 경우는 다른 생성자에서 호출 하여야 한다.

        System.out.println(String.format("#### 기본 생성자 Constructor() :: %s", this.name));
    }

    // 파라메터 하나인 생성자
    public Constructor(String name) {
        super();
        this.name = name;
        System.out.println(String.format("#### 생성자 Constructor(String name) :: %s", this.name));
    }
}
