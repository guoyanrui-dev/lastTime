package com.test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author guoyanrui on 2022/3/22
 */
public class testGetApi {
   public void sendGet() throws IOException {
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
//post
    public static void sendPost(String url, List<NameValuePair> params, HashMap<String,String> headers) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(url);
//        httpPost.setHeader("ContentType","application/x-www-form-urlencoded");
        httpPost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
//        Set<String> set = headers.keySet();
//        for(Iterator<String> iterator=set.iterator();iterator.hasNext();){
//            String key = iterator.next();
//            String value = headers.get(key);
//            httpPost.setHeader(key,value);
//        }
        headers.forEach((key,value)->{
            httpPost.setHeader(key,value);
        });
        CloseableHttpResponse httpPostResponse = client.execute(httpPost);
        JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(httpPostResponse.getEntity()));
        System.out.println(jsonObject.get("result"));
    }

    public static void main(String[] args) throws IOException {
       String url="https://api.apishop.net/common/postcode/getAddrs";
//       ?apiKey=hBcUuaPacd9143701e460219607c97752d070b3082954ac
        HashMap<String,String> map = new HashMap<>();
        map.put("ContentType","application/json");
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("apiKey","hBcUuaPacd9143701e460219607c97752d070b3082954ac"));
        sendPost(url,list,map);
    }
}
