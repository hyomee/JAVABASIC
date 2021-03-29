package com.hyomee.cleancode;

import java.util.*;

public class ClassDesign {
    public static void main(String[] agrs) {

        finalMember();
        protectClass();
        nullNoReturn();

    }
    private static void finalMember() {
        // final 용도
        MutableClass seoulToDaejeon = new MutableClass ("서울 to 대전 : ", 200);
        MutableClass daejeonToBusan = new MutableClass ("대전 to 부산 : ", 400);

        MutableClass seoulToDaejeonToBusan = seoulToDaejeon;
        seoulToDaejeonToBusan.add(daejeonToBusan);
        System.out.println("가변 :: 서울 to 대전 to 부산 :: " + seoulToDaejeonToBusan.value);

        // 서울 to 대전 거리 변경
        seoulToDaejeon.value = 300;
        System.out.println("가변 :: 서울 to 대전 :: " + seoulToDaejeon.value);
        System.out.println("가변 :: 서울 to 대전 to 부산 :: " + seoulToDaejeonToBusan.value);

        ImmutableClass seoulToDaejeonImmutable = new ImmutableClass ("서울 to 대전 : ", 200);
        ImmutableClass daejeonToBusanImmutable = new ImmutableClass ("대전 to 부산 : ", 400);
        ImmutableClass seoulToDaejeonToBusanImmutable = seoulToDaejeonImmutable.add(daejeonToBusanImmutable);
        System.out.println("서울 to 대전 to 부산  :: " + seoulToDaejeonToBusanImmutable.value);
        // seoulToDaejeonImmutable.value = 300 -> 불변 객체 이므로 수정 할 수 없음 ;
    }

    private static void protectClass() {
        List<City> cityList = new ArrayList<>();
        Cities cities = new Cities(cityList);
        System.out.println( " cities.getCities().size() :: " +  cities.getCities().size() );
        cityList.add(new City("서울"));
        System.out.println( " cities.getCities().size() :: " +  cities.getCities().size() );
        cities.getCities().add(new City("대전"));
        System.out.println( " cities.getCities().size() :: " +  cities.getCities().size() );
        System.out.println("=================================");
        cityList = new ArrayList<>();
        ProtectCities protectCities = new ProtectCities(cityList);
        System.out.println( " cities.getCities().size() :: " +  protectCities.getCities().size() );
        cityList.add(new City("서울"));
        System.out.println( " cities.getCities().size() :: " +  protectCities.getCities().size() );
        // protectCities.getCities().add(new City("대전")); // Error : java.lang.UnsupportedOperationException
    }

    private static void nullNoReturn() {
        City city = nullReturn.getCity("서울");
        System.out.println( " city.getCity() :: " +  city.getCity() );
        city = nullReturn.getCity("부산");

        if (city == null) {
            System.out.println(" 부산 ::  null ... ");
        } else {
            System.out.println(" city.getCity() : " + city.getCity());
        }

        city = nullNoReturn.getCity("서울");
        System.out.println( " city.getCity() :: " +  city.getCity() );
        city = nullNoReturn.getCity("부산");
        System.out.println( " 부산 :: city.getCity() :: " +  city.getCity() );
    }
}

class MutableClass {

    String name;
    int value;

    MutableClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    void add(MutableClass mutableClass) {
        this.value += mutableClass.value;
    }

}


class ImmutableClass {

    final String name;
    final int value;


    ImmutableClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    ImmutableClass add(ImmutableClass mutableClass) {
        return new ImmutableClass(name, value + mutableClass.value);
    }

}


class Cities {
    private final List<City> cities;

    Cities(List<City> cities) {
        this.cities = cities;
    }

    List<City> getCities() {
        return this.cities;
    }
}

class ProtectCities {
    private final List<City> cities;

    ProtectCities(List<City> cities) {
        this.cities = new ArrayList<>(cities);
    }

    List<City> getCities() {
        // 추가 삭제 막음 -> Read-Only
        return Collections.unmodifiableList(cities);
    }
}

class City {
    String city;

    City(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

class nullReturn {
    static List<City> cities = Arrays.asList(
            new City("서울"),
            new City("대전")
    );

    static City getCity(String cityName) {
        for (City city: cities) {
            if (city.getCity().equals(cityName)) {
                return city;
            }
        }

        return null;
    }
}

class nullNoReturn {

    private static final City city = new City("");

    static List<City> cities = Arrays.asList(
            new City("서울"),
            new City("대전")
    );

    static City getCity(String cityName) {
        for (City city: cities) {
            if (city.getCity().equals(cityName)) {
                return city;
            }
        }

        return city;
    }
}