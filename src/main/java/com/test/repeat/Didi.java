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
//        String string = readFile();

//        System.out.println(string);

//        String url = "https://jenkins-qiye.intra.xiaojukeji.com/job/b2b_pre_docker_18/build?delay=0sec";
//        Map<String,String> header = new HashMap();
//        Map<String,Object> body = new HashMap<>();
//        header.put("content-type","application/x-www-form-urlencoded");
//        header.put("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 12_6_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
//        header.put("cookie","html_template_is_multi_company=0; current_odin_platform=pc; SSO_AS_SUB_TICKET3114=6037c2a87b070c966db437a75c3f4f690003114000; SSO_AS_UID3114=guoyanrui_v; odin_jwt_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDI2MTE3MjYsImlhdCI6MTcwMDAxOTcyNiwiaXNzIjoib2Rpbi54aWFvanVrZWppLmNvbSIsInN1YiI6Imd1b3lhbnJ1aV92In0.5_ya3irHvGRuR8fxOLdrsTBtmH8aE6ywWnQQYpIh-Zg; remember-me=Z3VveWFucnVpX3Y6MTcwMTY5MzQxODg2Nzo0NzNkZTY2ZGMzODRhNWVhNTJlODA2MzRmNTE1MzBhNTI4ZWM4ZGIzOGZjNmIzZmE5OTAzODNhOGIwNTliNWY5; Hm_lvt_772d7f74297e288beb94aa9cef87d96a=1700532575; html_template_phone=11188880000; html_template_company_id=1125926143192877; html_template_uid=1002761381303083; html_template_member_id=1125926143196611; jenkins-timestamper-offset=-28800000; jenkins-timestamper=system; jenkins-timestamper-local=true; userId=2151945; ENG_prod_SESSION_ID=f71e0dde9d304c28a4f7b2f36d8a5518000915000; username=guoyanrui_v; username_zh=%E9%83%AD%E7%84%B1%E7%91%9E; Hm_lpvt_772d7f74297e288beb94aa9cef87d96a=1701337273; ticket=C5be3KMT73oIAejRPFdXJDZ1ydyLK0XsEcl0I_oe2aEczjuqw0AQRNG93LgR1dNP0qjTl3sP_sifZAw2joT2bsZRQQWHu9FEEoMGYTQn3WiFHKUiowXZ54_0WUXS4mG0keT_gHEkwTiRLpV58qgeCtUwLqQvbqzkxvv5eZ1Xcpbku3H9iR7L5F28kbh7rbVK6jH3_mA8SO3fAAAA__8%3D; auth_token=ZfNfa3DchkLR9cDrU%2FOOzCT6jVBcQ1nWkxXtaKS1Kueqro8WCY0xcAn7kRU5%2F9wtfhE6jyd%2FLcDRsm%2FQOuE8yB3gBi%2BSVTsPMBAWuhXj%2F55Cq1GYERG8L1ReJCE1uajRxUpSJxVSIe61pGn7HBjLPP1nRaJLi6bfTG6VvlH0N1h23mQaRa609tXhwbrvpWErKWiv2BMsYlKB%2FnX1VOkLYYDUoafZyigJSc8NG08h8MUdLrUnla9xSnE%2Bl6p2EByMDNdFG4qZRWZlyTZsIlMokamcf8OiJ8msJQM7bxhR1VH%2Bggmocf0Lgzic%2FQ7ru7I%2BI9MvwcV4Qhfq6zzxzzuUPADux95yQzVYKTAUbStehCSlTjV1ntMWICT8kUn7WkG688Vg%2BfiFnATwfHr%2B02gzXNSH1knY3eMgPShZK7lGAJtnQbW40uerSZaW9jEprZ7LSCg32P4%2Fvcok9mzivJGr4vwjrNz9M8NJkQUnv5%2FNtjkssoypEipnJRlPm3rWBI2qa6cTuV1bx5mDousIQw2XHa%2BhBeVzydRyIDfhWvq6tw7Ol45VgbfljWZjUi1hTLMmaD3tH0i6FTI%2FmEmrZBtSLfg%2BerYQY021h6GN3cBKMJhurPIucEZjCgyXtZxVE4HQpelfXMX3r0FyxULCesrFndHoj7JmYrTm1BYAwR%2B%2BF8cWw69%2BL1U%2FgFyNVsfGi8xGZA%2FdDfy1fkAj1ppijxTaCa%2FANAI0hxFF6629vEf2xXIxAg%2By3PECybB7TflWrfu3c799294cf9dea777db372d1162966ce3ca35aac7; JSESSIONID.df51aa9e=node01oog7afx51pgf1hu6ly0glixyz88660.node0; language=zh_CN");
//        body.put("parameter","[{\"name\": \"branch\", \"value\": \"feature_whitelist\"}, {\"name\": \"module\", \"value\": \"zeus\"}]");
//        body.put("statusCode","303");
//        body.put("redirectTo",".");
//        body.put("Submit","");
//        body.put("Jenkins-Crumb","1401f018a69f1306603d06d53623834f211e0ca52ad66077ed6986a914db45ca");
//        String json = HttpRequest.post(url)
//                .addHeaders(header)
//                .form(body)
//                .execute()
//                .body();
//        System.out.println(json);
    }

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
