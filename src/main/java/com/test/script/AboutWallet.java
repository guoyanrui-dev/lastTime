package com.test.script;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.util.*;

@Test
public class AboutWallet {
    Util util = new Util();

    /*
     *   用户钱包金额查询
     *
     * */
    public void getCash() {
        String url = util.Online_Host + "/river/Card/get";
        Map map = new HashMap<>();
        map.put("client_id", util.client_id);
        map.put("access_token", util.access_token);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("company_id", "1125926143192877");
        map.put("phone", "11188880000");
        String sign = util.getSign(map, util.signKey);
        map.put("sign", sign);
        String body = HttpRequest.get(url)
                .form(map)
                .execute()
                .body();
        System.out.println(JSON.parseObject(body));
    }
}
