package com.test.script;

import java.util.*;

public class AboutApril {
    public static void qukkkily(int[] nums, int left, int right) {
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
        qukkkily(nums, left, i - 1);
        qukkkily(nums, i + 1, right);
    }

    public static void bubblele(int[] nums) {
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

    public static void getCount(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : string.split("|")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        map.forEach((stt, count) -> {
            System.out.println(stt + "有" + count + "个");
        });
    }

    public static int getIndex(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (j - i) + i / 2;
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

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入curl：");
        String str = scanner.nextLine();

    }
}
