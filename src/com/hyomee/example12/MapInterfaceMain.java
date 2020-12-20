package com.hyomee.example12;

import java.util.*;


/**
 * Key와 갑으로 되어 있으며, Key는 중복 될 수 없음
 * - HashMap : Key들을 해쉬 함수를 사용하여 해쉬함
 * - LinkedHashMap : 키/값 하나의 엔트리를 이중 링크드 리스트로 구성(삽입 순서)
 * - TreeMap : 탐색트리 내에서 키들에 대한 전체적인 정렬을 Comparable 또는 Comparator 기능을 이용하여 정렬, 키/값 쌍을 정렬 된 순서로 저장
 */
public class MapInterfaceMain {

    public static void main(String[] arg) {
        Map<String, String> users = new HashMap<>();

        // isEmpty() Map이 비어 있는지 검사
        if (users.isEmpty()) {
            System.out.println(String.format("Map이 비어 있습니다. isEmpty() = %s", users.isEmpty() ));
        }

        // put() 추가
        users.put("홍길동", "30");
        users.put("김우기", "50");
        users.put("성우선", "60");

        // size() Map 크기를 구한다.
        System.out.println(String.format("Map 크기 :: isEmpty() = %s, size() => %s", users.isEmpty(), users.size()));

        // containsKey(Object Key) 특정키가 있는지 검사
        if  (users.containsKey("홍길동")) {
            System.out.println(String.format("Map에서 Key에 대한 Value :: %s", users.get("홍길동")));
        }

        // 값을 있는지 검사
        System.out.println(String.format("Map에서 Value 값 여부 존재함   :: %s", users.containsValue("60")));
        System.out.println(String.format("Map에서 Value 값 여부 존해하지 않음 :: %s", users.containsValue("40")));

        // Set keySet()
        Set<String> keys = users.keySet();
        for(String key: keys) {
            System.out.println(String.format("Map Key :: %s, Value :: %s", key, users.get(key)));
        }

        // Map의 값을 가지고 옴 values()
        Collection<String> values = users.values();
        for(String value: values) {
            System.out.println(String.format("Map Value :: %s", value));
        }

        // entrySet()
        Set<Map.Entry<String, String>> mapEntrys = users.entrySet();
        for(Map.Entry<String, String> mapEntry: mapEntrys) {
            System.out.println(String.format("Map Key :: %s, Value :: %s", mapEntry.getKey(), mapEntry.getValue()));
        }
        System.out.println("=====================================================");

        // HashMap : 정렬 되지 않믐
        Map<String, String> maps = new HashMap<>();
        maps.put("대한민국", "서울");
        maps.put("중국", "베이징");
        maps.put("이탈리아", "로마");
        for(Map.Entry<String, String> map : maps.entrySet()) {
            System.out.println("HashMap : " + map.getKey() + ", value : " + map.getValue());
        }

        System.out.println("=====================================================");
        // LinkedHashMap : 들어가 순서 대로
        Map<String, String> linkedHashMaps = new LinkedHashMap<>();
        linkedHashMaps.put("대한민국", "서울");
        linkedHashMaps.put("중국", "베이징");
        linkedHashMaps.put("이탈리아", "로마");
        for(Map.Entry<String, String> lhm : linkedHashMaps.entrySet()) {
            System.out.println("LinkedHashMap : " + lhm.getKey() + ", value : " + lhm.getValue());
        }
        System.out.println("=====================================================");
        // TreeMap :: 이름정렬
        SortedMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("대한민국", "서울");
        treeMap.put("중국", "베이징");
        treeMap.put("이탈리아", "로마");
        for(Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println("TreeMap : " + entry.getKey() + ", value : " + entry.getValue());
        }

    }
}
