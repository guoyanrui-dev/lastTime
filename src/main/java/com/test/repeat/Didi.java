package com.test.repeat;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.util.*;

import cn.hutool.http.HttpRequest;
import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class Didi {
    // 统计字符串中每个字符出现的次数
    public static void getStringCount(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : string.split("|")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        map.forEach((string1, count) -> System.out.println(string1 + "有" + count + "个" + "\t"));
    }


    //用流的形式读取文件内容
    @Test
    public static void readFileAsStream() throws IOException {
        User user = new User();
        List<String> list = new ArrayList<>();
        String url = "/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/file.txt";
//        File file = new File(url);
        Map<String, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            for (String str : line.split(",")) {
                list.add(str);
            }
            user.setId(list.get(0));
            user.setName(list.get(1));
            user.setAge(list.get(2));
            count += 1;
            if (count == 1) {
                break;
            }
        }
        System.out.println(user.getId() + " " + user.getName() + "  " + user.getAge());
    }

    // 利用HUtool库的readString方法直接读取
    public static String readFileAsHutool() {
        String url = "/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/file.txt";
        return FileUtil.readString(url, "utf-8");
    }


    public static void main(String[] args) {
        int[] nums = {1, 32, 4, 67, 2, 56};
        quiklySort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        HostInfo hostInfo = new HostInfo();
        System.out.println(hostInfo.getAddress());

    //给定一个int数组，按从小到大进行排序
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


}
