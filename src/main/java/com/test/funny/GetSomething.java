package com.test.funny;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetSomething {
    //插入排序
    public static void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int index = i - 1;
            if (index >= 0 && value < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = value;
        }
    }

    //kuaisu
    public static void quik(int[] nums, int left, int right) {
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
        quik(nums, left, i - 1);
        quik(nums, i + 1, right);
    }

    //
    public static int binary(int[] nums, int target) {
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

    public static void getCount(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : str.split("|")) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        map.forEach((string1, count) -> {
            System.out.println(string1 + " 有" + count + " 个");
        });
    }

    public static void main(String[] args) {
        String str = "njnfdjbhfnnnfnff";
        getCount(str);
        int[] nums = {3, 12, 5, 89, 67};
//        insert(nums);
//        quik(nums, 0, nums.length - 1);
        bubble(nums);
        int sort = binary(nums, 67);
        System.out.println(sort);
        System.out.println(Arrays.toString(nums));
    }
}
