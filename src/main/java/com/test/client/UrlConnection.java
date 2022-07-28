package com.test.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.istack.internal.NotNull;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.CheckedOutputStream;

public class UrlConnection {
    public static JSONObject sendgetHttp(String url,@NotNull String... args) throws IOException {
        URL url1 = new URL(url);
        HttpURLConnection connection  =(HttpURLConnection) url1.openConnection();
//        for(int i=0;i<args.length;i++){
//            String key = args[i].substring(0,args[i].indexOf("="));
//            String value = args[i].substring(args[i].indexOf("=")+1);
//            connection.setRequestProperty(key,value);
//        }
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        OutputStream outputStream  = connection.getOutputStream();
        outputStream.write(args.toString().getBytes("utf-8"));
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String temp;
        while ((temp =bufferedReader.readLine())!=null){
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
        String url = "https://api.apishop.net/common/postcode/getAddrs";
        JSONObject jsonObject = sendgetHttp(url,"apikey=hBcUuaPacd9143701e460219607c97752d070b3082954ac");
        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
    }
}
