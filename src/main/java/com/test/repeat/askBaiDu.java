package com.test.repeat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guoyanrui on 2022/4/1
 */
public class askBaiDu {
    @Test
    void ask() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://baidu.com");
        post.setHeader("ContentType","application/json");
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("zhansgan","lisi"));
        post.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse execute = client.execute(post);
        String string = EntityUtils.toString(execute.getEntity());
//        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(string);
    }
}
