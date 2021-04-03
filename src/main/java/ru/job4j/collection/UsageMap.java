package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanivanov@gmail.com", "Ivan Ivanov");
        for (Map.Entry<String, String> rsl : map.entrySet()) {
            System.out.println(rsl.getKey() + " = " + rsl.getValue());
        }
    }
}
