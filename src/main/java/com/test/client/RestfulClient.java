package com.test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author guoyanrui on 2022/3/22
 */
public class RestfulClient {
    CloseableHttpClient httpClient;
    HttpGet httpGet;
    CloseableHttpResponse httpResponse;
    int responseCode;
    JSONObject reponsebody;
    HashMap<String, String> reponseHeaders;
    //通过http获取请求反馈
    public void getResponse(String url) throws IOException {
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        httpClient.execute(httpGet);
    }

    //以json格式获取反馈的主体
    public JSONObject getBodyInJson() throws IOException {
        HttpEntity httpEntity;
        String entityString;
        httpEntity = httpResponse.getEntity();
        entityString = EntityUtils.toString(httpEntity, "utf-8");
        reponsebody = JSON.parseObject(entityString);
        return reponsebody;
    }

    //以hash获取返回头部信息
    public HashMap<String, String> getHeaderInHash() {
        Header[] headers;
        headers = httpResponse.getAllHeaders();
        reponseHeaders = new HashMap<String, String>();
        for (Header header : headers) {
            reponseHeaders.put(header.getName(), header.getValue());
        }
        return reponseHeaders;
    }

    //获取反馈的状态码
    public int getstatusCode() {
        responseCode = httpResponse.getStatusLine().getStatusCode();
        return responseCode;
    }
}
