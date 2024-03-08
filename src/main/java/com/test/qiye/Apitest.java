package com.test.qiye;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.script.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
@Test
public class Apitest {

    //获取申请的差旅制度id
    @Test
    public static void getRegulationId(){
        String url = "https://api.es.xiaojukeji.com/river/Regulation/get";
        Map<String, Object> map = Request.getParamsMap(url);
        Util trainUtil = new Util();
        map.put("access_token", trainUtil.getAcess_token());
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        Map<String,String> map1 = new HashMap<>();
        map.forEach((key,value)->{
            map1.put(key,String.valueOf(value));
        });
        String sign = trainUtil.getSign(map1, "1d5f4338101c9712de9a");
        map.put("sign", sign);
        String resut = Request.sendPostRequest(url, map);
        System.out.println(JSON.parseObject(resut));
    }
    //创建申请单
    @Test
    public static void create(){
        Util trainUtil = new Util();
        String url = "https://api.es.xiaojukeji.com/river/Approval/create";
        Map<String,Object> map = Request.getParamsMap(url);
        map.put("access_token",trainUtil.getAcess_token());
        map.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
        Map<String,String> map1 = new HashMap<>();
        map.forEach((key,value)->{
            map1.put(key,String.valueOf(value));
        });
        String sign_key = "1d5f4338101c9712de9a";
        String sign = trainUtil.getSign(map1, sign_key);
        map.put("sign",sign);
        String result = Request.sendPostRequest(url,map);
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println(jsonObject);
        Assert.assertEquals(jsonObject.get("errno"),0,jsonObject.get("errmsg").toString());
    }
}
