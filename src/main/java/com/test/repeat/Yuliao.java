package com.test.repeat;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;


public class Yuliao {

//测试分布

    public static void main(String[] args) {
        String url = "http://lse2-search-data-factory.amap.test/us/queryLog";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("queryString","uri:\"/coupon/common/coupon/info\" and \"coupon_business=gasstation\"");
        jsonObject.put("totalSize",10000);
        jsonObject.put("serverName","lse2-us-bff-coupon-service");
        jsonObject.put("ossPath","oss://search-qa/guoyanrui/bff_coupon.txt");
        HttpResponse httpResponse = HttpRequest.post(url)
                        .body(String.valueOf(jsonObject))
                        .execute();
        System.out.println(httpResponse.body());
//        System.out.println(6.55*2775900);
    }

}
