package com.hyomee;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


class UserConsumer implements Consumer<String> {
    public void accept(String s) {
        System.out.println("Consumer impl :: " + s);
    }

}

public class ExpForEach {

    private List<String> list ;

    public ExpForEach() {
        String[] strArr = new String[]{"파이선", "자바"};
        list = (List) Arrays.asList(strArr);

    }

    public void printForEach() {

        System.out.println("#### Iterator ");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(String.format("Iterator :: 값 = %s", iter.next()));
        }

        System.out.println("#### for ");
        for( String str: list) {
            System.out.println(String.format("for :: 값 = %s", str));
        }

        System.out.println("#### UserConsumer ");
        list.forEach(new UserConsumer() {
            public void accept(String s) {
                System.out.println(String.format("UserConsumer :: 값 = %s", s));
            }
        });

        System.out.println("#### forEach ");
        list.forEach(str -> System.out.println(String.format("forEach :: 값 = %s", str)));

        System.out.println("#### System.out::println ");
        list.forEach(System.out::println);

    }
}
