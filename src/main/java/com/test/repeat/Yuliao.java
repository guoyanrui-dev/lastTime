package com.test.repeat;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;


public class Yuliao {



    public static void main(String[] args) {
        String url = "http://lse2-search-data-factory.amap.test/us/queryLog";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("queryString","url:\"/search/poi_brief\" and \"query_src=us-java-list-charging\"");
        jsonObject.put("totalSize",30000);
        jsonObject.put("serverName","lse2-us-pouch");
        jsonObject.put("ossPath","oss://search-qa/guoyanrui/pouch.txt");
        HttpResponse httpResponse = HttpRequest.post(url)
                        .body(String.valueOf(jsonObject))
                        .execute();
        System.out.println(httpResponse.body());
    }


}
