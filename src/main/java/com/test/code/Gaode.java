package com.test.code;

import java.util.Arrays;

public class Gaode {
    //kuaisuopai
    public static void  quikly(int[] nums,int left,int right){
        if(left>right){
            return;
        }
        int i =left;
        int j = right;
        int base = nums[i];
        while (i!=j){
            while (nums[j]>=base && i<j){
                j--;
            }
            while (nums[i]<=base&&i<j){
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quikly(nums,left,i-1);
        quikly(nums,i+1,right);
    }

  //二分查找 目标值的下标
    public static int index(int[] nums,int target){
        int i = 0;
        int j = nums.length-1;
        while (i<=j){
          int  mid = i+(j-i)/2;
          if (nums[mid]==target){
              return mid;
          } else if (nums[mid]>target) {
              j=mid-1;
          }else i = mid+1;
        }
        return -1;
    }
 // 冒泡排序
    public static void bubble(int[] nums){
        for(int i = 0;i<nums.length-1;i++){
            for (int j = 0;j<nums.length-1-i;j++){
                if (nums[j+1]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums= {1,4,23,67,4334,8,89,99,78};
        bubble(nums);
//        quikly(nums,0,nums.length-1);
//        int index_target = index(nums,89);
        System.out.println(Arrays.toString(nums));
//        System.out.println(index_target);
    }
}
