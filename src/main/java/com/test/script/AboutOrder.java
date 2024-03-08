package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Test
public class AboutOrder {

    Util util = new Util();

    /*
     * 用车订单列表
     * */
    public void getOrderListl() {
        String url = util.Online_Host + "/river/Order/get";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("call_phone", "11188880000");
        map.put("offset", "0");
        map.put("length", "5");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }

    /*
     * 用车订单详情
     *
     * */
    public void getOrderDetail() {
        String url = util.Online_Host + "/river/Order/detail";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("order_id", "1125929615316055");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
}
