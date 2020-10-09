package com.hyomee.example06;


class MemberVarTest {
    private int i = 0;

    public MemberVarTest(int i) {
        this.i = i;
        System.out.println(String.format("#### MemberVarTest : i: %s  ", i));
    }
}

public class StaticInit {
    private MemberVarTest memberVarTestA = new MemberVarTest(i);
    private MemberVarTest memberVarTestB;
    public static int i ;
    public static int num[] = new int[3];


    static {
        System.out.println("#### Class 초기화 블럭 실행");
        for (int i = 0 ; i < 3; i++) {
            num[i] = i;
        }
        System.out.println("#### Class 초기화 블럭 종료");
    }

    {
        memberVarTestB = new MemberVarTest(2);
    }

    public StaticInit() {
        System.out.println("### StaticInit 진입시작 ");
        System.out.println(String.format("#### StaticInit : static i: %s  ", i));
        System.out.println(String.format("#### StaticInit : num length : %s  ", num.length));
        for (int i = 0 ; i < num.length; i++) {
            System.out.println(String.format("#### StaticInit : static num[%s] : %s ", i, num[i]));
        }
    }
}
