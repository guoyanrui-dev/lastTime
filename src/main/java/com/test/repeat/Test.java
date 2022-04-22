package com.test.repeat;

import javax.print.attribute.HashAttributeSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author guoyanrui on 2022/4/22
 **/
public class Test {
    String str = "jsjkskfk";

    //寻找字符串中出现次数最多的字符
    public static void search(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : str.split("|")) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        int max = 0;
        String strrr = "出现最大次数的字符是";
        Set<String> set = map.keySet();
        for (String string1 : set) {
            if (map.get(string1) > max) {
                max = map.get(string1);
            }
            if (map.get(string1) == max) {
                strrr += string1 + " ";
            }
        }
        System.out.println(strrr);
    }

    public static void main(String[] args) {
        String string = "aaabbbc";
        search(string);
    }
}
