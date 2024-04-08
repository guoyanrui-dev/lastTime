package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
@Test
public class AboutBill {
    /*
    * @business_line  业务线（0：网约车；1：商旅；100：出租车）
    * */
    Util util = new Util();
    /*
     * 账单列表
     * */
    public void billList(){
        String url = util.Host + "/river/Bill/get";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("business_line", "0");
        map.put("offset", "0");
        map.put("length", "1");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
    /*
    * 账单下载
    * */
    public void downLoadBill() throws IOException {
        String url = util.Host + "/river/Bill/download";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("business_type", "100");
        map.put("bill_id", "1125929433758838");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();

    }
}
