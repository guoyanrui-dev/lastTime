package com.test.code;

import java.util.Arrays;

public class SortQuikly {
    public static void quiklysort(int[] nums, int left, int right) {
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
        quiklysort(nums, left, i - 1);
        quiklysort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 7, 8, 32, 89, 98, 322};
        quiklysort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j+"\t");
            }
            System.out.println();
        }
    }
}
