package com.test.code;

import java.util.Arrays;

/**
 * @author guoyanrui on 2022/3/25
 */
public class SearchSort {
    //二分查找
    public int biSerach(int[] nums, int targer) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == targer) {
                return mid;
            } else if (nums[mid] > targer) {
                right = mid - 1;
            } else left = mid + 1;

        }
        return -1;
    }

    //charupaixu
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

    //kuaisu
    public static void quiklySort(int[] nums, int left, int right) {
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
        quiklySort(nums, left, i - 1);
        quiklySort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 34, 56, 67, 98, 53, 97, 90, 43};
//        new SearchSort().insertSort(nums);
//        quiklySort(nums, 0, nums.length - 1);
        new SearchSort().bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
}
