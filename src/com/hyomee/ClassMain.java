package com.hyomee;

class ClassMain {
    static int counter;

    public static void main(String[] args) {
        int total = sum(10, 30);

//        AutoInitVariable autoInitVariable = new AutoInitVariable();
//        autoInitVariable.printVarible();

/*
        ExpForEach expForEach = new ExpForEach();
        expForEach.printForEach();
*/
        Array04 array04 = new Array04();
        array04.expArray04();
    }

    static int sum(int i, int j) {
        int sum = i + j;
        counter = counter + 1;
        return sum;
    }
}
