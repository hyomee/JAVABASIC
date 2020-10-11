package com.hyomee.example10;

import java.util.ArrayList;
import java.util.List;


/**
 * 제네릭(Generic)은 클래스 내부에서 사용하는 데이터의 타입(Type)을 클래스의 인스턴스를 생성할 때 결정하는 것.
 * 객체의 타입을 컴파일 시점에 체크하기 때문에 타입 안정성을 높이고 형 변환의 번거로움을 줄일 수 있음.
 * 기본 데이터 타입(int, long..)에 대해서는 지정이 불가능
 * 사용법
 *    public class 클래스명<T> {...}
 *    public interface 인터페이스명<T> {...}
 * 자주 사용 하는 타입인자
 *   <T>	Type
 *   <E>	Element
 *   <K>	Key
 *   <N>	Number
 *   <V>	Value
 *   <R>	Result
 */
public class GenericMain {

    public static void main(String[] args) {
        GenernicClassSingle<String> genernicString = new GenernicClassSingle<String>();
        genernicString.memberVar = "문자";
        genernicString.printType();

        GenernicClassSingle<Integer> genernicInteger = new GenernicClassSingle<Integer>();
        genernicInteger.memberVar = 1;
        genernicInteger.printType();


        ArrayList<String> list = new ArrayList<String>();
        list.add("하나");
        list.add("둘");

        GenernicClassSingle<ArrayList> genernicArrayList = new GenernicClassSingle<ArrayList>();
        // genernicArrayList.memberVar =  new ArrayList<String>();  // type 결정
        //  genernicArrayList.memberVar = list;                     // 참조에 의헌 type 결정
        genernicArrayList.memberVar = (ArrayList) list.clone();     // 복제에 위한 type 결정
        genernicArrayList.memberVar.add("셋");

        genernicArrayList.printType();

        for (Object str: genernicArrayList.memberVar) {
            System.out.println(String.format(" GenernicArrayList.memberVar :: Value :: %s", str));
        }

        for (String str: list) {
            System.out.println(String.format(" list :: Value :: %s", str));
        }

        // Multi Type 테스트
        oederdPairTest();

        genericMethodTest();

        // 제한
        GenericTypeBounded<Integer> box = new GenericTypeBounded<>();
        GenericTypeBounded.set("Hi"); // compile error

    }

    private static void oederdPairTest() {
        // 복수 제너릭
        // - 시용 시점에 형 결정 됨
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
        Pair<String, Integer> p3 = new OrderedPair<String, Integer>("Even", 10);

        System.out.println(String.format(" p2 [ Key :: %s (Type : %s), Value :: %s (Type : %s)",
                p1.getKey(),
                p1.getKey().getClass().getTypeName(),
                p1.getValue(),
                p1.getValue().getClass().getTypeName()));

        System.out.println(String.format(" p2 [ Key :: %s (Type : %s), Value :: %s (Type : %s)",
                p1.getKey(),
                p1.getKey().getClass().getTypeName(),
                p1.getValue(),
                p1.getValue().getClass().getTypeName()));
    }

    private static void genericMethodTest() {
        Integer aInt = GenericMethod.printData(1);
        Double aDouble = GenericMethod.printData(1.0);
        String aString = GenericMethod.printData("Stirng");
        String aStringA =  GenericMethod.<String>printData("문자");
    }

}

// 담수 제너너릭 Genernic Class 생성
class GenernicClassSingle<T> {

    // example은 T type으로 인스턴스가 생성 될 때 결정이 된다.
    public T memberVar;

    public void printType () {
        System.out.println(String.format("Type :: %s, Value :: %s", memberVar.getClass().getTypeName(), memberVar));
    }

}


// 복수 제너릭
interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K,V> implements Pair<K,V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

}

// 제너릭 메서드
class GenericMethod {

    public static <T> T printData(T data) {
        if(data instanceof String)
            System.out.println("String");
        else if(data instanceof Integer)
            System.out.println("Integer");
        else if(data instanceof Double)
            System.out.println("Double");

        return data;
    }
}

//
class Calcu {
    public void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj + " ");
        }
    }

    public int sum(List<? extends Number> list) {
        int sum = 0;
        for (Number i : list) {
            sum += i.doubleValue();
        }
        return sum;
    }

    public List<? super Integer> addList(List<? super Integer> list) {
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
        return list;
    }
}