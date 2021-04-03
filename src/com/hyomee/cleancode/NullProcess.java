package com.hyomee.cleancode;

import java.util.Objects;

/**
 * Null 처리
 * -> 개발시 null을 체크 하는 것은 업무에 따라 본질적으로 선택 사항 으로 다른 방법으로 리팩토링 하는 것이 좋은 코드 이다.
 * -> NNullPointerException을 발행 할 수 있어서 null체크를 하는 이것을 자바 기본 API에서 제공 되는 함수를 이용해서 처리 할 수 있다.
 */
public class NullProcess {
    public static void main(String[] agrs) {
        Business business = new Business();
        String str = null;
        business.generalNullCheckCode(str);
        business.nullToDefaultValue(str);
        business.nullPointExceptionOccurrence(str);
    }
}


class Business {

    /**
     * 일바 적인 개발 형태로 null 처리 로직을 코드에 반영한 코드
     * @param str
     */
    public void generalNullCheckCode(String str) {
        if (str == null) {
            System.out.println("### Null 체크 일반 적인 개발 형태 ");
            return;
        }
        System.out.println("### 엄부 로직");
    }

    /**
     * Null이면 강제 NullPointerException 발생
     * @param str
     */
    public void nullPointExceptionOccurrence(String  str) {
        Objects.requireNonNull(str);
        System.out.println("### :: str ::  " + str);
    }

    /**
     * Null이면 다른 값으로 변환
     * @param str
     */
    public void nullToDefaultValue(String  str) {
        str = Objects.requireNonNullElse(str, "변환값");
        System.out.println("### :: 기본값 변환 :: str :: " + str);
    }


}


