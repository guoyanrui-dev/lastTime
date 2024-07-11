package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AboutAddNoTelUser {
    Util util = new Util();

    //添加无手机号员工
    @Test
    public void addUserNoTel(){
        String url = util.Host + "/river/Member/single";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125928578703627");
        map.put("data", "{\"email\":\"watchscript@163.com\",\"member_type\":2,\"realname\":\"郭焱瑞无手机号234\",\"residentsname\":\"Shanghai\",\"employee_number\":\"8018236\",\"use_company_money\":1,\"total_quota\":10000}");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.post(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
}
