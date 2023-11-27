package com.test.repeat;

import java.util.HashMap;
import java.util.Map;

public class Didi {
    public static void getStringCount(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : string.split("|")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        map.forEach((string1, count) -> System.out.println(string1 + "有" + count + "个" + "\t"));
    }

}
