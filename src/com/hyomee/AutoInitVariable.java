package com.hyomee;

public class AutoInitVariable {

    boolean aBoolean;     char aChar;
    Byte aByte;           short aShort;
    int anInt;            long aLong;
    Float aFloat;         Double aDouble;
    Object object;

    public AutoInitVariable(){
    }

    public void printVarible() {
        System.out.println(String.format("boolean aBoolean :: %s", aBoolean));
        System.out.println(String.format("char aChar :: %s", aChar));
        System.out.println(String.format("Byte aByte :: %s", aByte));
        System.out.println(String.format("short aShort :: %s", aShort));
        System.out.println(String.format("int anInt :: %s", anInt));
        System.out.println(String.format("long aLong :: %s", aLong));
        System.out.println(String.format("Float aFloat :: %s", aFloat));
        System.out.println(String.format("Double aDouble :: %s", aDouble));
        System.out.println(String.format("Object object :: %s", object));
    }
}
