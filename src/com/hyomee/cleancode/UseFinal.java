package com.hyomee.cleancode;

import java.util.*;

/**
 * 기본적으로 객체는 불볍 상태이다.
 * 가별 상태는 코드의 작성에 따라서 잘못된 결과를 초래 할 수 있다.
 */
public class UseFinal {
    public static void main(String[] agrs) {

        MutableClass seoulToDaejeon = new MutableClass ("서울 to 대전 : ", 200);
        seoulToBusan(seoulToDaejeon);

        ImmutableClass seoulToDaejeonImmutable = new ImmutableClass ("서울 to 대전 : ", 200);
        finalSeoulToBusan(seoulToDaejeonImmutable);


        protectClass();
        nullNoReturn();

    }

    private static void seoulToBusan(MutableClass seoulToDaejeon) {

        MutableClass daejeonToBusan = new MutableClass ("대전 to 부산 : ", 400);

        MutableClass seoulToDaejeonToBusan = seoulToDaejeon;
        // 서울 to 대전 to 부산 거리 계산
        seoulToDaejeonToBusan.add(daejeonToBusan);
        System.out.println("가변 :: 서울 to 대전 to 부산 :: seoulToDaejeonToBusan :: "
                + seoulToDaejeonToBusan.value);

        // 서울 to 대전 거리 변경를 변경 하면
        seoulToDaejeon.value = 300;
        // 서울 to 대전 to 부산 거리를 재 계산 하면
        seoulToDaejeonToBusan.add(daejeonToBusan);
        // 거리가 변경이 된다.
        System.out.println("가변 :: 서울 to 대전 to 부산 :: seoulToDaejeonToBusan :: "
                + seoulToDaejeonToBusan.value);

    }

    private static void finalSeoulToBusan(ImmutableClass seoulToDaejeonImmutable) {

        ImmutableClass daejeonToBusanImmutable =
                new ImmutableClass ("대전 to 부산 : ", 400);
        ImmutableClass seoulToDaejeonToBusanImmutable =
                seoulToDaejeonImmutable.add(daejeonToBusanImmutable);
        System.out.println("불변 :: 서울 to 대전 to 부산  :: "
                + seoulToDaejeonToBusanImmutable.value);

        // seoulToDaejeonImmutable.value = 300; // -> 불변 객체 이므로 수정 할 수 없음 ;
    }

    private static void protectClass() {
        System.out.println("===    private static void protectClass()  ===============");
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
        System.out.println("===    private static void nullNoReturn()  ===============");
        City city = ExplicitNullReturn.getCity("서울");
        System.out.println( " city.getCity() :: " +  city.getCity() );
        city = ExplicitNullReturn.getCity("부산");

        if (city == null) {
            System.out.println(" 부산 ::  null ... ");
        } else {
            System.out.println(" city.getCity() : " + city.getCity());
        }

        city = ObjectNullNeturn.getCity("서울");
        System.out.println( " city.getCity() :: " +  city.getCity() );
        city = ObjectNullNeturn.getCity("부산");
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

class ExplicitNullReturn {
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

class ObjectNullNeturn {

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