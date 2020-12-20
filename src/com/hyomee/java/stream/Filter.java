package com.hyomee.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

  public static void main(String[] arg) {

    List<String> address = new ArrayList<>();
    address.add("서울시 송파구 방이동");
    address.add("서울시 송파구 송파동");
    address.add("서울시 강남구 개포동");
    address.add("서울시 강남구 서초동");


    Stream<String> addressStream = address.stream();
    List<String> songpa = addressStream.filter(s -> s.contains("송파구")).collect(Collectors.toList());
    songpa.stream().forEach(s-> System.out.println(s));

  }
}
