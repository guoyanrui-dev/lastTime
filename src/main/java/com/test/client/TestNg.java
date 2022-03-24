package com.test.client;


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
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoyanrui on 2022/3/22
 */
public class TestNg {
    @Test
    public JSONObject sendpost(String url, List<NameValuePair> list, Map<String, String> headers) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        headers.forEach((key, value) -> {
            httpPost.setHeader(key, value);
        });
        httpPost.setHeader("ContentType", "application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse execute = client.execute(httpPost);
        String string = EntityUtils.toString(execute.getEntity());
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(string);
        return jsonObject;
    }

    @Test
    public void test() throws IOException {
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("apiKey", "hBcUuaPacd9143701e460219607c97752d070b3082954ac"));
        Map<String, String> map = new HashMap<>();
        map.put("ContentType", "application/json");
        JSONObject jsonObject = sendpost("https://api.apishop.net/common/postcode/getAddrs", list, map);
        System.out.println(jsonObject.get("result"));
    }
}
