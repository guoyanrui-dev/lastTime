package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AboutCar {
    String string = "jknjknjk";

    public static void getCount(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : string.split("|")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        map.forEach((string1, key) -> {
            System.out.println(string1 + "有" + key + "个");
        });
    }

    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void quikly(int[] nums, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int base = nums[i];
        while (i != j) {
            while (nums[j] >= base && i < j) {
                j--;
            }
            while (nums[i] <= base && i < j) {
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quikly(nums, left, i - 1);
        quikly(nums, i + 1, right);
    }

    @Test
    public static void flowerJiu() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    public static String sendRequst(String url,Map map) {
        String response = HttpRequest.get(url)
                .body(map.toString())
                .execute()
                .body();
        return response;
    }
    public static String sendRequst(String url) {
        String response = HttpRequest.get(url)
                .execute()
                .body();
        return response;
    }

    public static void main(String[] args) {
        String str = "hjh";
        int[] nums = {1, 3, 2, 4, 6, 5, 7, 9, 8, 10};
        //快速
//        quikly(nums, 0, nums.length - 1);
        //冒泡
        bubble(nums);
        System.out.println(Arrays.toString(nums));
        getCount(str);
    }

}
