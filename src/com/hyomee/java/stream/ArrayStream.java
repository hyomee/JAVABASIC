package com.hyomee.java.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStream {
  public static void main(String[] arg) {

    String[] strings = new String[]{"c#", "java", "java script"};

    // Stream 변환
    System.out.println("===== Stream 변환 =======");
    Stream<String> stringStream = Arrays.stream(strings);
    stringStream.forEach(s -> System.out.println(s));

    System.out.println("===== 배열에서 원하는 요소 찾기 =======");
    // 배열에서 원하는 요소 찾기
    Stream<String> stringStreamOfElement = Arrays.stream(strings, 1,3) ;
    stringStreamOfElement.forEach(s -> System.out.println(s));
  }
}
