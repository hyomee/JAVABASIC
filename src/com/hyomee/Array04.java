package com.hyomee;

import java.util.Arrays;
import java.util.Collections;

public class Array04 {
    public Array04() {
    }

    public void expArray04() {
        int[] a = {1, 2, 3};                // int형 배열 선언 및 값 할당
        int a1[];                         // int형 배열 선언
        a1 = new int[]{3, 2, 1, 4, 6, 5};           // 배열 생성

        System.out.println("#### 크기 :: " + a.length);
        for (int i : a1) System.out.print("a1 :: " + i + "\n");

        String[] as = {"array", "of", "string"};
        String[] as1 = {"another", "array"};


        System.out.println("\n#### 크기 as ::" + as.length);
        Arrays.asList(as).forEach(s -> System.out.println("as :: " + s));

        as = as1;
        System.out.println("\n#### 크기 as = as1 ::" + as.length);

        Arrays.asList(as).forEach(System.out::println);
        System.out.println("\n#### 정렬");
        // 정렬
        Arrays.sort(as);
        Arrays.asList(as).forEach(s -> System.out.println("a1 sort 오름 차순 :: " + s));

        Arrays.sort(as, Collections.reverseOrder());
        Arrays.asList(as).forEach(s -> System.out.println("a1 sort 내림 차순 :: " + s));
    }

}