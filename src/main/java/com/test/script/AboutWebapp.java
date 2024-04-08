package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AboutWebapp {
    Util util = new Util();

    public String chineseToEncode(String string) throws UnsupportedEncodingException {
        String urlencode = java.net.URLEncoder.encode(string, "UTF-8");
        return urlencode;
    }

    public String decodeToChinese(String string) throws UnsupportedEncodingException {
        String chinese = java.net.URLDecoder.decode(string, "UTF-8");
        return chinese;
    }

    @Test
    public void getAuthCode(){
        String url = util.Host + "/river/Login/getLoginEncryptStr";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("app_type", "2");
        map.put("phone", "11188880000");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        String response = JSON.parseObject(body).getJSONObject("data").get("encrypt_str").toString();
        String auth_code = response.substring(response.indexOf("auth_code="),response.indexOf("&p"));
        System.out.println(response);
        System.out.println(auth_code);
    }


    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        System.out.println(new AboutWebapp().chineseToEncode("弘愿新时代"));
    }
}
