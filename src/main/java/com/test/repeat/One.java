package com.test.repeat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoyanrui on 2022/4/6
 */
public class One {
    //kuaipai
    public void quikly(int[] nums, int left, int right) {
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

    //maopao
    public void bubble(int[] nums) {
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

    //charu
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int index = i - 1;
            while (index >= 0 && value < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = value;
        }
    }

    //erfen
    public int binary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {21, 43, 6, 2, 68, 43, 868, 6, 76586, 654643, 678};
        One sort = new One();
//        sort.quikly(nums, 0, nums.length - 1);
//        sort.bubble(nums);
        sort.insertSort(nums);
        int i = sort.binary(nums, 6);
        String string = Arrays.toString(nums);
        Map<String, Integer> map = new HashMap<>();
        for (String string1 : string.split(",")) {
            if (map.containsKey(string1)) {
                map.put(string1, map.get(string1) + 1);
            } else map.put(string1, 1);
        }
        map.forEach((str, so) -> System.out.println(str + "有" + so + "个"));
        System.out.println(i);
    }
}
