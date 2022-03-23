package com.test.code;

import java.util.Arrays;

/**
 * @author guoyanrui on 2022/3/23
 */
public class Binary {
    //kuai
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

    //mao
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
//erfen
    public int erfen(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {12, 43, 2312, 645, 65878, 3412, 5, 7889, 3, 9};
//        new Binary().quikly(nums, 0, nums.length - 1);
        new Binary().bubble(nums);
        int index = new Binary().erfen(nums, 12);
        System.out.println(Arrays.toString(nums));
        System.out.println(index);
    }
}
