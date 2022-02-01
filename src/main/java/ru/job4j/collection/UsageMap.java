package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1@1.ru", "Ivan Ivanov");
        map.put("2@2.ru", "Petr Petrov");
        map.put("3@3.ru", "Artem Sidorov");
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
