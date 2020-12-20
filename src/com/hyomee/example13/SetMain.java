package com.hyomee.example13;

import java.util.*;

/**
 * Collection 인터페이스를 확장하는 Set 인터페이스는 중복 값을 저장할 수 없는 정렬되지 않은 객체 컬렉션
 *
 * java.util.EnumSet : 열거형 값만 포함할 수 있다.
 *
 * java.util.HashSet : 해싱을 이용하여 구현, 중복을 허락하지 않고 순서를 보장하지 않는 Set의 대표 구현체
 *
 * java.util.LinkedHashSet :  모든 요소가 Double Linked List로 유지되는 HashSet의 정렬 된 버전으로 데이터의 저장된 순서가 유지된다.
 *
 * java.util.TreeSet : 값 저장을 위해 이진탐색트리를 사용, 추가와 삭제에는 시간이 조금 더 걸리지만 정렬, 검색에 높은 성능을 보이는 자료구조. 기본적으로 데이터를 오름차순으로 정렬한다
 */
public class SetMain {
    public static void main(String[] arg) {
        Set<String> vhashSet = new HashSet<String>();
        vhashSet.add("서울");
        vhashSet.add("대구");
        vhashSet.add("대전");
        vhashSet.add("부산");
        vhashSet.add("광주");

        System.out.println(vhashSet);

        // 반복적을 이용한 출력
        System.out.println("======== 반복절을 이용한 출력 ");
        Iterator inter = vhashSet.iterator();
        while (inter.hasNext()) {
            System.out.println(inter.next());
        }

        System.out.println("======== for ");
        for(String str: vhashSet) {
            System.out.println(str);
        }

        System.out.println("======== stream ");

        vhashSet.stream().forEach((s) ->  System.out.println(s));

        System.out.println("======== LinkedHashSet ");
        Set<String> vLinkHashSet = new LinkedHashSet<String>();
        vLinkHashSet.add("서울");
        vLinkHashSet.add("대구");
        vLinkHashSet.add("대전");
        vLinkHashSet.add("부산");
        vLinkHashSet.add("광주");
        vLinkHashSet.stream().forEach((s) ->  System.out.println(s));

        System.out.println("======== TreeSet ");
        Set<String> vTreeSet = new TreeSet<String>();
        vTreeSet.add("서울");
        vTreeSet.add("대구");
        vTreeSet.add("대전");
        vTreeSet.add("부산");
        vTreeSet.add("광주");
        vTreeSet.stream().forEach((s) ->  System.out.println(s));
    }
}
