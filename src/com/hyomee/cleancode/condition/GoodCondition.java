package com.hyomee.cleancode.condition;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodCondition {

    public static void main(String[] agrs) {
        AntiCondition antiCondition = new AntiCondition();
        String result = antiCondition.compare("나무");
        System.out.println(String.format("RESULT : %s", result));
    }

}


class AntiCondition {
    Animal animal = new Animal();

    public static final String RESULT_ANIMAL = "ANIMAL";
    public static final String RESULT_PLANT = "PLANT";
    public static final String RESULT_UNDEFINED = "UNDEFINED";


    public String compare(String compareStr) {
        if (animal.isAnimal(compareStr) == true) {
            return RESULT_ANIMAL;
        } else {
            return isPlant(compareStr);
        }
    }

    private String isPlant(String compareStr) {
        if (animal.isPlant(compareStr) == true) {
            return RESULT_PLANT;
        } else {
            return RESULT_UNDEFINED;
        }
    }
}

class Animal {
    private ArrayList<String> animals = new ArrayList<>(Arrays.asList("사자", "고양이", "호랑이"));
    private ArrayList<String> plants = new ArrayList<>(Arrays.asList("나무", "꽃", "잡초"));

    public Boolean isAnimal(String animalName) {
        return animals.stream().anyMatch(p->p.equals(animalName));
    }

    public Boolean isPlant(String plantName) {
        return plants.stream().anyMatch(p->p.equals(plantName));
    }

}