package com.hyomee.example09;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
 * 이름없는 익명 함수 구현에서 주로 사용하며 함수형 인터페이스의 인스턴스(구현 객체)를 표현
 * 함수형 인터페이스 (추상 메소드가 하나인 인터페이스)를 구현 객체를 람다식으로 표현
 */
public class LambdaMain {
    public static void main(String[] args) {

        // 익명 클래스
        PrintNm printNmA  = new PrintNm() {
            @Override
            public void printName(String name) {
                System.out.println(String.format("이름 : %s", name));
            }
        };

        printNmA.printName("홍길동....");

        // 람다식
        PrintNm printNm = (name) -> {
            System.out.println(String.format("이름 : %s", name));
        };

        printNm.printName("홍길동");
        printNm.defaultPrintName("홍길자");

        ArrayList<String> citys = new ArrayList<String>();
        citys.add("SEOUL");
        citys.add("BUSAN");

        System.out.println("### Consumer ====================");
        citys.forEach( new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("### Consumer I/F 구현객체를 람다로 구현 ====================");
        citys.forEach(s -> System.out.println(s));
        System.out.println("### Consumer I/F 구현객체를 람다로 구현 축약 ====================");
        citys.forEach(System.out::println);

        System.out.println("### FunctionInterface ====================");
        FunctionInterfaceTest functionInterfaceTest = new FunctionInterfaceTest();
        functionInterfaceTest.runWorker();

        CalculationClass calculationClass = new CalculationClass(5, 3);
    }
}


interface PrintNm {
    void printName(String name);

    // default를 쓰면 인터페이스 내부에서도 코드가 포함된 메소드를 선언 할 수 있다.
    default void defaultPrintName(String name) {
        System.out.println(String.format("이름 : %s", name));
    }
}

@FunctionalInterface
interface Worker {
    public void work();
}

class FunctionInterfaceTest {

    void execute(Worker worker) {
        worker.work();
    }

    public void runWorker() {
        execute(new Worker() {
            @Override
            public void work() {
                System.out.println("Worker 실행");
            }
        });

        execute( () -> System.out.println("Worker 람다식 실행"));
    }
}

// 상송에 의한 인처페이스
@FunctionalInterface
interface Calculation {
    Integer apply(Integer x, Integer y);
}

class CalculationClass {


    // 인터페이스와 두개의 인자를 받아서 계산하는 Method
    static Integer calculate(Calculation calculation, Integer x, Integer y) {
        return  calculation.apply(x, y);
    }

    // 람다 함수 셍성
    private Calculation addition = (x, y) -> x+y;
    private Calculation subtraction = (x, y) -> x-y ;

    public CalculationClass(Integer x, Integer y) {
        // 함수 사용
        System.out.println(String.format("%s + %s = %s", x, y, calculate(addition, 2,2)));
        System.out.println(String.format("%s + %s = %s", x, y, calculate(subtraction, 2,2) ));
    }

}

