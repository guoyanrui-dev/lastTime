package com.test.client;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author guoyanrui on 2022/3/24
 */
public class Request {
    //post
    public JSONObject sendPostRequest(String url, Map<String, String> param, Map<String, String> headers) throws IOException {
        List<NameValuePair> list = new ArrayList<>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        headers.forEach((key, value) -> {
            httpPost.setHeader(key, value);
        });
        param.forEach((parakey, paramValue) -> {
            list.add(new BasicNameValuePair(parakey, paramValue));
        });
        httpPost.setHeader("ContentType", "application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse execute = client.execute(httpPost);
        String string = EntityUtils.toString(execute.getEntity());
        JSONObject jsonObject = JSON.parseObject(string);
        return jsonObject;
    }

    //get
    public JSONObject sendGetRequest(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("ContentType", "application/json");
        CloseableHttpResponse execute = client.execute(httpGet);
        String string = EntityUtils.toString(execute.getEntity());
        return JSON.parseObject(string);

    }
}
