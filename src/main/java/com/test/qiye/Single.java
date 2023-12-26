package com.test.qiye;

import java.util.Arrays;

public class Single {

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

    public static void main(String[] args) {
        int[] nums = {1, 45, 2, 87, 54, 67, 44};
        quikly(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}