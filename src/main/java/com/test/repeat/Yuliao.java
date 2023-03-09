package com.test.repeat;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Yuliao {


    public static void main(String[] args) {
        String url = "http://lse2-search-data-factory.amap.test/us/queryLog";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("queryString", "uri:\"/search_shelf/tips_list_shelf\"");
        jsonObject.put("totalSize", 20000);
        jsonObject.put("serverName", "lse2-us-shelf-service");
        jsonObject.put("ossPath", "oss://search-qa/guoyanrui/charging_shelf.txt");
        HttpResponse httpResponse = HttpRequest.post(url)
                .body(String.valueOf(jsonObject))
                .execute();
        System.out.println(httpResponse.body());
    }

}
