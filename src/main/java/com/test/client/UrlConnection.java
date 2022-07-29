package com.test.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.istack.internal.NotNull;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

public class UrlConnection {
    public static JSONObject sendgetHttp(String url, String params) throws IOException {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
//        for(int i=0;i<args.length;i++){
//            String key = args[i].substring(0,args[i].indexOf("="));
//            String value = args[i].substring(args[i].indexOf("=")+1);
//            connection.setRequestProperty(key,value);
//        }
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(params.getBytes("utf-8"));
        outputStream.flush();
        outputStream.close();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            buffer.append(temp);
            buffer.append("\r\n");
        }
        JSONObject jsonObject = JSONObject.parseObject(buffer.toString());
        connection.disconnect();
        inputStream.close();
        bufferedReader.close();
        return jsonObject;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://11.164.95.218:8099/bin/search?auction&_sid_=1117251129629489&group_module=groupmeta_poi_detail&show_fields=all&sourcefrom=loadrunnertest&use_log=false&outfmt=json";
//        Map<String,String> map = new HashMap();
        JSONObject json = new JSONObject();
        json.put("apikey", "hBcUuaPacd9143701e460219607c97752d070b3082954ac");
        String param = "{\"apikey\":\"hBcUuaPacd9143701e460219607c97752d070b3082954ac\"}";
//        map.put("apikey","hBcUuaPacd9143701e460219607c97752d070b3082954ac");
//        JSONObject jsonObject = sendgetHttp(url,param);
//        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
        String jsonObject = HttpRequest.get(url)
                .execute()
                .body();
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject);
        System.out.println(JSON.toJSONString(jsonObject1, SerializerFeature.PrettyFormat));
    }

}
