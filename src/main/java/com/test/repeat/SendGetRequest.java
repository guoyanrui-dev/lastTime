package com.test.repeat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoyanrui on 2022/4/4
 */
public class SendGetRequest {
    final CloseableHttpClient client = HttpClients.createDefault();

    //get
    public void getResponse(String url, Map<String, String> headers) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        headers.forEach((key, value) -> httpGet.setHeader(key, value));
        CloseableHttpResponse execute = client.execute(httpGet);
        String string = EntityUtils.toString(execute.getEntity());
        System.out.println(string);
    }

    //post
    public void postResponse(String url, Map<String, String> headers, Map<String, String> form) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        headers.forEach((key,value) -> httpPost.setHeader(key, value));
        form.forEach((name, value1) -> {
            list.add(new BasicNameValuePair(name, value1));
        });
        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse execute = client.execute(httpPost);
        String string = EntityUtils.toString(execute.getEntity());
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject.get("result"));
    }

    @Test
    public void testGet() throws IOException {
        String url = "http://baidu.com";
        Map<String, String> map = new HashMap<>();
        map.put("ContentType", "application/json");
        getResponse(url, map);
    }
}
