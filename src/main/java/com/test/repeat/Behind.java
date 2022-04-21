package com.test.repeat;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @Author guoyanrui on 2022/4/21
 **/
public class Behind {
    public static void main(String[] args) {
//        String str = "1123";
//        String str2 = "5869";
//        String s = str + str2;
//        String[] nums = s.split("|");
//        int[] array = Arrays.asList(nums).stream().mapToInt(Integer::parseInt).toArray();
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < nums.length - 1 - i; j++) {
//                if (array[j + 1] < array[j]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(strToInt("89738","012838")));
    }
    public static int[] strToInt(String str1,String str2){
        String s = str1+str2;
        int[] nums= Arrays.asList(s.split("|")).stream().mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        return nums;
    }
}
