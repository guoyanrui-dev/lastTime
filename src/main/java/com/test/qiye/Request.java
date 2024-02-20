package com.test.qiye;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.oracle.tools.packager.Log;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Request {
    //发送请求
    public static String sendPostRequest(String url, Map<String, Object> hashMap) {
        String result = "";
        String string = FileUtil.readString("/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/create.json", "utf-8");
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(string);
        Map<String, Object> map = new HashMap<>(jsonObject);
        List list = new ArrayList<>();
        map.forEach((key, value) -> {
            list.add(key);
        });
        if (list.contains(url)) {
            JSONObject jsonObject1  = new JSONObject(hashMap);
            result = HttpRequest.get(url).header("content-type", "application/json").form(jsonObject1).execute().body();
        } else {
//            Log.info("未查询到此接口信息");
        }
        return result;
    }

    // 更新接口所需字段
    public static Map<String, Object> getParamsMap(String url) {
        String string = FileUtil.readString("/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/create.json", "utf-8");
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(string);
        Map<String, Object> map = new HashMap<>(jsonObject);
        Map<String, String> map1 = new HashMap<>();
        List list = new ArrayList<>();
        map.forEach((key, value) -> {
            list.add(key);
        });
        if (list.contains(url)) {
            String params = (String) map.get(url);
            com.alibaba.fastjson.JSONObject jsonbody = JSON.parseObject(params);
            Map<String, Object> mapparam = jsonbody.getInnerMap();
            return mapparam;
        } else {
//            Log.info("未查询到此接口信息");
        }
        return map;
    }

}
