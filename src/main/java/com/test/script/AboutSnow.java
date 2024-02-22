package com.test.script;

import java.util.Arrays;

public class AboutSnow {
    public static void quaipaixu(int[] nums, int left, int right) {
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
        quaipaixu(nums, left, i - 1);
        quaipaixu(nums, i + 1, right);
    }
    public static boolean isHuiWen(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        if(stringBuilder.reverse().toString().equals(string)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {12, 4, 564, 78, 454, 6};
        quaipaixu(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
