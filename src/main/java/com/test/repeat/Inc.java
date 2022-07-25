package com.test.repeat;

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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inc {

    public void sendRequest(String url,  Map<String,String> body) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        body.forEach((key,value)->{
            list.add(new BasicNameValuePair(key,value));
        });
        post.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse res = client.execute(post);
        String string = EntityUtils.toString(res.getEntity());
//        JSONObject jsonObject = JSON.parseObject(string);
//        System.out.println(jsonObject);
        System.out.println(string);
    }

    public static void main(String[] args) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("application","json");
        new Inc().sendRequest("http://baidu.com",map);
    }
}
