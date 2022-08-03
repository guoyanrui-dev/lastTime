package com.test.code;

import java.util.Arrays;

public class Sort {
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

    public static void main(String[] args) {
        int[] nums = {1, 45, 2, 676, 98, 9, 36, 9};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
}
