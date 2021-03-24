package com.hyomee.cleancode.condition;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodCondition {

    public static void main(String[] agrs) {
        String name = "나무";

        // 1. 블필요한 표현식
        AntiCondition antiCondition = new AntiCondition();


        String result = antiCondition.compare(name);
        System.out.println(String.format("RESULT : %s", result));

        // 2. 블필요한 표현식 제거
        NotCondition notCondition = new NotCondition();
        result = notCondition.compare(name);
        System.out.println(String.format("RESULT : %s", result));

        // 3. 부정을 긍정으로 변ㄴ경
        Condition condition = new Condition();
        result = condition.compare(name);
        System.out.println(String.format("RESULT : %s", result));

        // 4. 직접 반환을 통한 지저분 한 코드 제거
        name = null;
        ValidAnimal validAnimal = new ValidAnimal();
        if (!validAnimal.isValidMessy(name)) {
            System.out.println("isValidMessy :: 잘못 된 이름 입니다.");
        }

        if (!validAnimal.isValid(name)) {
            System.out.println("isValid :: 잘못 된 이름 입니다.");
        }

        if (!validAnimal.isValidDeMogans(name)) {
            System.out.println("isValidDeMogans :: 잘못 된 이름 입니다.");
        }

        if (!validAnimal.isValidSeparation(name)) {
            System.out.println("isValidSeparation :: 잘못 된 이름 입니다.");
        }

    }

}

/**
 * 블필요한 표현식
 * boolean 인 경우 == true, == false
 */
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
        if (animal.isPlant(compareStr) == false) {
            return RESULT_UNDEFINED;
        } else {
            return RESULT_PLANT;
        }
    }
}

/**
 * 블필요한 표현식 제거
 */
class NotCondition {
    Animal animal = new Animal();

    public static final String RESULT_ANIMAL = "ANIMAL";
    public static final String RESULT_PLANT = "PLANT";
    public static final String RESULT_UNDEFINED = "UNDEFINED";


    public String compare(String compareStr) {
        if (animal.isAnimal(compareStr)) {
            return RESULT_ANIMAL;
        } else {
            return isPlant(compareStr);
        }
    }

    private String isPlant(String compareStr) {
        if (!animal.isPlant(compareStr)) {
            return RESULT_UNDEFINED;
        } else {
            return RESULT_PLANT;
        }
    }
}

/**
 * 부정을 긍적으로 변경
 */
class Condition {
    Animal animal = new Animal();

    public static final String RESULT_ANIMAL = "ANIMAL";
    public static final String RESULT_PLANT = "PLANT";
    public static final String RESULT_UNDEFINED = "UNDEFINED";


    public String compare(String compareStr) {
        if (animal.isAnimal(compareStr)) {
            return RESULT_ANIMAL;
        } else {
            return isPlant(compareStr);
        }
    }

    private String isPlant(String compareStr) {
        if (animal.isPlant(compareStr)) {
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

class ValidAnimal {

    // 지저분한 코드는 소스가 길어 지고 가독성이 떨어 진다.
    public boolean isValidMessy(String name) {
        if ( name == null || name.length() <= 0 || name.trim().isEmpty()  ) {
            return false;
        } else {
            return true;
        }
    }

    // 지저분한 코드 제거
    public boolean isValid(String name) {
        return  (name != null && !name.trim().isEmpty()) && name.length() <= 0  ;
    }

    // 드 모르간 법칙을 이용 적용한 간소화
    // !A && !B = !(A || B ) 참
    // !A || !B = !(A && B ) 참
    public boolean isValidDeMogans(String name) {
        boolean isValidName = !(name == null || name.trim().isEmpty());
        return isValidName && name.length() <= 0;
    }

    // 조건문이 복잡 할 경우 분리를 통한 간소화
    public boolean isValidSeparation(String name) {
        return isNameNull(name) && isNameLength(name);
    }

    private boolean isNameLength(String name) {
        return name.length() <= 0;
    }

    private boolean isNameNull(String name) {
        return !(name == null || name.trim().isEmpty());
    }
}

