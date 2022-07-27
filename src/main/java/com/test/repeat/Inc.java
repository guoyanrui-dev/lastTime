package com.test.repeat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Inc {
    public static final String output = "json";
    public static final String channel = "amap7a";
    public static final String personal_switch = "on";
    public static final String user_adcode = "110000";
    public static final String sign = "5B8D42F1A0885005E2411945E3E3D875";
    public static final String appstartid = "364505293";
    public static final String spm = "15487983883129284205840848085435";
    public static final String csid = "622a1a0c-2a3c-4ce8-a18b-db3fa51cf521";
    public static final String gsid = "common-alibaba011164087208.eu95sqa02472a32d5f7f57e20a9abdac4b0c7eb";
    public static final String user_loc = "116.47335%2C39.993217";
    public static final String testid = "3836_52_2043_1622_1849_89_1908_2118_285_1631_4492_2371_5299_2495_5360_4699_4568_4875_4981_4129_4027_2916_3078_3720_3843_3925_4284_4386_4409_4422_4566_5564_5079_5168_5188_5240_10024_11090_10043_10164_10369_10169_10167_10172_10293_10214_10339_10676_10929_10355_10358_2099_10406_10451_10504_10498_10508_10519_10223_10523_10526_10551_11156_10584_10598_10601_10621_10627_10642_10776_10660_10699_10719_10744_10755_10759_10770_10860_10795_10790_10830_10866_10882_10885_10900_10918_10945_10954_10645_11100_11000_11034_11038_11044_11049_11059_11062_11064_11068_11083_11112_10106_11116_11106_11129_11132_11123_11119_11019_11142_11147_10840_10876_11162_11032_11198_11026_11207_10858_10724_11252_11255_11269_11279_11276_11286_11293_11314_11338_11280\"";
    public static final String modules = "['common_service','tour_trends2','collector_guide','operation_banner']";
//    public String getOutput() {
//        return output;
//    }

    /*
     * httpClient
     * */
    public JSONObject sendRequest(String url, Map<String, String> body) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        body.forEach((key, value) -> {
            list.add(new BasicNameValuePair(key, value));
        });
        post.setEntity(new UrlEncodedFormEntity(list));
        CloseableHttpResponse res = client.execute(post);
        String string = EntityUtils.toString(res.getEntity());
        JSONObject jsonObject = JSONObject.parseObject(string);
        return jsonObject;
    }

    /*
     * httpurlconnection
     * */
    public static JSONObject geturl(String url, String... args) throws IOException, IllegalAccessException {
        HttpURLConnection connection = null;
        InputStream in = null;
        BufferedReader br = null;
        String result = null;
        URL url1 = new URL(url);
        connection = (HttpURLConnection) url1.openConnection();
        Field[] filed = new Inc().getClass().getFields();
        for (Field field1 : filed) {
            connection.setRequestProperty(field1.getName(), (String) field1.get(new Inc()));
        }
        for (int i = 0; i < args.length; i++) {
            String key = args[i].substring(0, args[i].indexOf("="));
            String value = args[i].substring(args[i].indexOf("=") + 1);
            connection.setRequestProperty(key, value);
        }
        in = connection.getInputStream();
        br = new BufferedReader(new InputStreamReader(in, "utf-8"));
        String temp;
        StringBuffer buffer = new StringBuffer();
        while ((temp = br.readLine()) != null) {
            buffer.append(temp);
            buffer.append("\r\n");
        }
        result = buffer.toString();
        in.close();
        br.close();
        connection.disconnect();
        return JSONObject.parseObject(result);
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
//        Map<String,String> map = new HashMap<>();
//        map.put("application","json");
        String url = "http://us-search-poi-sit.amap.test/search/poi/detail?";
//        url += "&poiid=B016300FN5&ajxVersion=nearby:051032;scenic_area:050755;poi:051115;travel:050120;walkman:030410;idqplus:051032;idqmax:050906;search:050967;search_around:050300;hotel:050906;landing_page:050906;tour:050815;search_cloud:050964;poi_cloud:050964;favorites:050961;nearby_cloud:050955;comment:050967;order_center:050955";

//        JSONObject result = new Inc().sendRequest(url,map);
        JSONObject jsonObject = geturl(url, "poiid=B016300FN5", "ajxVersion=nearby:051032;scenic_area:050755;poi:051115;travel:050120;walkman:030410;idqplus:051032;idqmax:050906;search:050967;search_around:050300;hotel:050906;landing_page:050906;tour:050815;search_cloud:050964;poi_cloud:050964;favorites:050961;nearby_cloud:050955;comment:050967;order_center:050955");
        // 格式化输出json字符串 SerializerFeature.PrettyFormat
        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
    }

    public void test(String... args) {
        for (int i = 0; i < args.length; i++) {
            String key = args[i].substring(0, args[i].indexOf("="));
            String value = args[i].substring(args[i].indexOf("=") + 1);
            System.out.println("keyshi" + key + ";" + "\r\n" + "valueshi" + value);
        }
    }

    @Test
    public void get() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        String version = "njsk:kjfnjk;jdnjk:jnji";
        test("name1=value1","name2=value2","va="+version);

    }
}
