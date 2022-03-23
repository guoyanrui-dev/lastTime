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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guoyanrui on 2022/3/23
 */
public class SendRequest {
    @Test
    public void post() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url="https://api.apishop.net/common/postcode/getAddrs";
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("apiKey","hBcUuaPacd9143701e460219607c97752d070b3082954ac"));
        post.setHeader("ContentType","application/json");
        post.setEntity(new UrlEncodedFormEntity(list,"utf-8"));
        CloseableHttpResponse execute = client.execute(post);
        String string = EntityUtils.toString(execute.getEntity());
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject.get("result").toString());
    }

    public static void main(String[] args) {
        String string= "{\"kjfmk\":\"lkfdmk\"}";
        System.out.println(JSON.parseObject(string));
    }
}
