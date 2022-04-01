package com.test.repeat;

import java.util.Arrays;

/**
 * @author guoyanrui on 2022/4/1
 */
public class Sort {
    //erfenzhanzhao
    public static int binary(int[] nums, int target) {
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

    //kuaisupaixu
    void quikl(int[] nums, int left, int right) {
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
        quikl(nums, left, i - 1);
        quikl(nums, i + 1, right);
    }

    //charupaixu
    void charu(int[] nums) {
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

    //maopao
    void bubble(int[] nums) {
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
        int[] nums={12,42,6,4,7867,53,7,97,54,869,43};
//        new Sort().bubble(nums);
//        new Sort().quikl(nums,0,nums.length-1);
        new Sort().charu(nums);
        int binary = binary(nums, 53);
        System.out.println(Arrays.toString(nums));
        System.out.println(binary);
    }
}
