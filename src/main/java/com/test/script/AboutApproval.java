package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AboutApproval {
    Util util = new Util();
    public void getOrderDetail() {
        String url = util.Host + "/river/Order/detail";
//        Map map = new HashMap<>();
//        map.put("client_id", util.client_id);
//        map.put("access_token", util.access_token);
//        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
//        map.put("company_id", "1125926143192877");
//        map.put("order_id", "1125929821691310");
//        String sign = util.getSign(map, util.signKey);
//        map.put("sign", sign);\
        JSONObject jsonObject = new JSONObject();

        String body = HttpRequest.get(url)
                .form(jsonObject)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
    @Test
    //删除差旅单
    public  void cancelApproval() {
        String[] nums = {"1125932719699459","1125932657045565"};
        for (int i = 0; i < nums.length; i++) {
            String url = util.Host + "/river/Approval/cancel";
            Map map = new HashMap<>();
            map.put("client_id", util.client_id);
            map.put("access_token", util.access_token);
            map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            map.put("company_id", "1125926143192877");
            map.put("approval_id", nums[i]);
            map.put("is_force", "1");
            String sign = util.getSign(map, util.signKey);
            map.put("sign", sign);
            String body = HttpRequest.post(url)
                    .form(map)
                    .execute()
                    .body();
            System.out.println(JSON.parseObject(body));
        }
    }
}
