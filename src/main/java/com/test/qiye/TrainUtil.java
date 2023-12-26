package com.test.qiye;

import cn.hutool.http.HttpRequest;
//import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.testng.annotations.Test;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class TrainUtil {
    String sign;
    String access_token;

    //读取文件内信息作为参数传递
    @Test
    public static void readFileParam() throws IOException {
//        String string = FileUtil.readString("/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/create.json", "utf-8");
//        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(string);
//        System.out.println(jsonObject);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/test/create.json"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(line);
        System.out.println(jsonObject);
    }

    //java md5算法
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("utf-8"));
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("no such algorithm！");
        }


        String md5code = new BigInteger(1, secretBytes).toString(16);
        int length = md5code.length();
        for (int i = 0; i < 32 - length; i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    //获取签名sign
    public String getSign(Map<String, String> params, String signKey) {
        params.put("sign_key", signKey);
        String result = "";
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(params.entrySet());
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造签名键值对的格式
            for (Map.Entry<String, String> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    String key = item.getKey();
                    String val = item.getValue().trim();
                    if (result == "") {
                        result += key + "=" + val;
                    } else {
                        result += "&" + key + "=" + val;
                    }
                }
            }
            //System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
        return md5(result);
    }

    //获取请求access_token
    public String getAcess_token() {
        String url = "https://api.es.xiaojukeji.com/river/Auth/authorize";
        String signKey = "1d5f4338101c9712de9a";
        HashMap<String, String> map = new HashMap<>();
        map.put("client_id", "029ce6c063b53a02a36427fe22ea18d7_test");
        map.put("client_secret", "b543c583a191659c518712d9c9cd3d51");
        map.put("grant_type", "client_credentials");
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("phone", "00016204527");
        String sign = getSign(map, signKey);
        map.put("sign", sign);
        JSONObject jsonObject = new JSONObject(map);
        String body = HttpRequest.post(url).header("content-type", "application/json").form(jsonObject).execute().body();
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(body);
        if (json.keySet().contains("access_token")) {
            return json.get("access_token").toString();
        }
        return "";

    }


}
