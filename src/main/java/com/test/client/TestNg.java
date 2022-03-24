package com.test.client;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guoyanrui on 2022/3/22
 */
public class TestNg {


    public static void main(String[] args) throws IOException {
        Request request = new Request();
        String posturl = "https://api.apishop.net/common/postcode/getAddrs";
        String getUrl = "https://api.apishop.net/common/postcode/getAddrs?apiKey=hBcUuaPacd9143701e460219607c97752d070b3082954ac";
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        params.put("apiKey", "hBcUuaPacd9143701e460219607c97752d070b3082954ac");
        headers.put("contentType", "application/json");
//        JSONObject jsonObject = request.sendPostRequest(posturl, params, headers);
        JSONObject jsonObject1 = request.sendGetRequest(getUrl);
        System.out.println(jsonObject1.get("result"));

    }
}
