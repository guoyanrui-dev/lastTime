package com.test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author guoyanrui on 2022/3/22
 */
public class testGetApi {
    public static void main(String[] args) throws IOException {
        String url = "https://api.apishop.net/common/postcode/getAddrs?apiKey=hBcUuaPacd9143701e460219607c97752d070b3082954ac";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("ContentType", "application/json");
        HttpResponse execute = httpClient.execute(httpGet);
        //返回状态码
        int statusCode = execute.getStatusLine().getStatusCode();
        //返回实体信息
        HttpEntity entity = execute.getEntity();
        //返回头信息
        Header[] allHeaders = execute.getAllHeaders();
        String string = EntityUtils.toString(entity);
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println("实体信息：" + jsonObject.get("result"));
        System.out.println("头信息是：" + allHeaders);
        System.out.println("状态码是：" + statusCode);
    }

}
