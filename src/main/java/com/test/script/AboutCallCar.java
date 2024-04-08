package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Test
public class AboutCallCar {
    Util util = new Util();
    String order_id = getOrderId();
    String dynamic_md5 = priceCoupon();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String formattedDate = sdf.format(date);

    /*
     * 发起叫车请求
     * */
    @Test(priority = 2)
    public void sendCallCarRequest() {
        String url = util.Host + "/v1/order/Create/request";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("order_id", order_id);
        map.put("rule", "301");
        map.put("type", "0");
        map.put("flat", "40.049959");
        map.put("flng", "116.295694");
        map.put("tlat", "40.0789");
        map.put("tlng", "116.59478");
        map.put("start_name", "弘源·新时代西南门");
        map.put("end_name", "西二旗铭科苑");
        map.put("require_level", "600");
        map.put("car_poll", "1");
        map.put("city", "20");
        map.put("passenger_phone", "11188880000");
        map.put("station_id", "4b6433474f73756d4f634e396b514875427978353371686c4c52725859655555");
        map.put("enable_lineup", "0");
        map.put("enable_reassign", "0");
        map.put("dynamic_md5", dynamic_md5);
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.post(url)
                .form(map)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .execute()
                .body();

        System.out.println(JSON.parseObject(body));
    }

    /*
     * 取消订单
     * */
    @Test(priority = 3)
    public void cancelOrder() {
        String url = util.Host + "/v1/order/Cancel";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("order_id", order_id);
        map.put("force", "true");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.post(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }

    /*
     *
     * 获取请求id
     * */
    @Test(priority = 0)
    public String getOrderId() {
        String url = util.Host + "/v1/order/Create/orderId";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        return JSON.parseObject(body).getJSONObject("data").get("order_id").toString();

    }

    /*
     * 预估价格;价格md5,通过 新的预估价接口获得
     * */
    @Test(priority = 1)
    public String priceCoupon() {
        String url = util.Host + "/v1/common/Estimate/priceCoupon";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("flat", "40.049959");
        map.put("flng", "116.295694");
        map.put("tlat", "40.0789");
        map.put("tlng", "116.59478");
        map.put("require_level", "600");
        map.put("rule", "301");
        map.put("city", "20");
        map.put("type", "0");
        map.put("passenger_phone", "11188880000");
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        return JSON.parseObject(body).getJSONObject("data").getJSONObject("600").get("dynamic_md5").toString();

    }

    /*
     * 确认支付
     * */
    @Test(enabled = false)
    public void pay_feeconfirm() {
        String url = util.Host + "/v1/order/FeeConfirm";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("order_id","1125929850755589");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.post(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
}
