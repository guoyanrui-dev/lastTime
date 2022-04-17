package com.test.repeat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author guoyanrui on 2022/4/14
 **/
public class Lose {
    //排序
    public static void kuaipai(int[] nums, int left, int right) {
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
        kuaipai(nums, left, i - 1);
        kuaipai(nums, i + 1, right);
    }

    //二分查找
    public static int binary(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    //charupaixu
    public static void insertSort(int[] nums) {
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

    //访问下百度试试
    public static void main(String[] args) throws IOException {
        int[] nums={1,3,21,43,543,65,7657,54,86,6565};
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://baidu.com");
        httpPost.setHeader("ContentionType", "application/json");
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("key", "value"));
        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse execute = client.execute(httpPost);
        String string = EntityUtils.toString(execute.getEntity());
//        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(string);
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
