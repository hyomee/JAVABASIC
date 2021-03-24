package com.hyomee.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UseCollection {

    public static void main(String[] agrs) {
        ForCollection forCollection = new ForCollection();
        // 1. for 문에 의한 인데스 변형
        System.out.println("고양이는 존재 하나요 (getAnimal) ?  " + forCollection.getAnimal("고양이") );

        // 2. for-each
        System.out.println("고양이는 존재 하나요 (getAnimalForEach)?  " + forCollection.getAnimalForEach("고양이") );

        // 3. for-each 내우 에서 객체 변형
        System.out.println("고양이는 존재 하나요 (getAnimalForEach)?  " + forCollection.getSetAnimal("고양이") );
    }
}

class ForCollection {
    private List<String> animals = Arrays.asList("사자", "고양이", "호랑이");

    public void printAnimal() {
        for(String animal :  animals) {
            System.out.println("동물 ::  " + animals);
        }
    }

    // i변수에 변형이 발생 하면 원하는 결과를 얻을 수 없다.
    public Boolean getAnimal(String animalName) {
        for ( int i = 0; i< animals.size() ; i++) {
            // i 값에 변경이 될 수 있음
            String animal = animals.get(i);
            if (animal.equals(animalName)) {
                return true;
            }
            // i 값에 변경이 될 수 있음
            i = i + 1;
        }

        return false;
    }

    // for - each
    public Boolean getAnimalForEach(String animalName) {
        for(String animal :  animals) {
            if (animal.equals(animalName)) {
                return true;
            }
        }

        return false;
    }

    public Boolean getSetAnimal(String animalName) {
        for(String animal :  animals) {
            if (animal.equals(animalName)) {
                animals.remove(animalName);
                return true;
            }
        }
        return false;
    }



}
