package com.test.repeat;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class eightSixteen {
    // kuaisusu
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

    public static String sendrequest(String url,Map<String,Object> body) {
        String body1 = HttpRequest.get(url)
                .form(body)
                .execute()
                .body();
        return body1;
    }

    public static void main(String[] args) {
        int[] nums = {21, 342, 6, 8, 4534553, 7676, 964, 121, 356, 7657, 458, 43};
        quiklySort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        Map<String,Object> map = new HashMap<>();
        map.put("apiKey","hBcUuaPacd9143701e460219607c97752d070b3082954ac");
        String url = "http://api.apishop.net/common/postcode/getAddrs";
        String string = sendrequest(url,map);
        JSONObject jsonObject = JSONObject.parseObject(string);
        System.out.println(jsonObject);
    }

}
