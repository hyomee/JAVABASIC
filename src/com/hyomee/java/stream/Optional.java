package com.hyomee.java.stream;

public class Optional {

  public static void main(String[] arg) {
    String string = "a string in optional";
    Optional<String> opString = Optional.of(string);
    System.out.println(opString.get());
  }



}
