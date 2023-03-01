package com.test.code;

import java.util.*;

public class Pation {

    //bubble
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

    // quikly

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

    // erfen
    public static int erfen(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    //charu
    public static void insertSort(int[] nums) {
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

    // map
    public static void stringtest(String str) {
        int max = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String string : str.split("|")) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        for (String string : map.keySet()) {
            if (map.get(string) > max) {
                max = map.get(string);
            }
        }
    }

    public static void main(String[] args) {
        int[] nusm = {12, 53, 32, 4, 7, 9, 32, 23, 6, 98};
//        bubble(nusm);
//        quikly(nusm, 0, nusm.length - 1);
        insertSort(nusm);
        int sort = erfen(nusm, 32);
        System.out.println(Arrays.toString(nusm));
        System.out.println(sort);
    }
}
