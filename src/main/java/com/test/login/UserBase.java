package com.test.login;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UserBase {
    private final  int appid = 10004;
    private final  String api_version = "1.0.4";
    private final  String lang = "zh-CN";
    private final  String os_type = "ios";
    private final  String app_version = "3.7.6";
    private final  String canonical_country_code = "CN";
    private final  String country_calling_code = "+86";
    private final  String ddfp = "09b5aa8d37566610a8b4bdb03debaf5f1e77d529";
    private final  int scene = 3;
    private final  String cell_encrypted ="00016204527";
    private final  int password_encrypt_type = 1;

    @Test
    public static void getLoginByCell(){
        String url = "https://epassport.diditaxi.com.cn/passport/login/v5/signInByPassword?wsgenv=eV60A7pTM43JNg2lAAAAAGADAAAf4OcUZ5YZifimpVUKjzbdx3Hs8QoPTkuB7E/gPMlTZr9OaPBtPSaZlhv2CVBT6nKNwcUIzUr3iJnNxK6TMf8ebBS%2BLiEU5dIdr62H7p22//QO1v91KV4wpyO%2BAZS9b82p9Yj9tmpAv3H8DJTqPbN0rYFLWEqnoFL/zbMH6A%2BEPuRIOkzajiBYMtg1eP4hxVKhZc5zLZypF6%2BspdGsCzpDDK2oiT3psj3ek5893U2iYOIvKfC5RUgFkNsFMxwk2g4fUxNtAtjQTtXseRfHO%2BzjVzJJiVImkwmbVv9g4a/KUhj4q2XkqXxMfphKRB2HSHR/cuTOUYDt%2BxxZDrmDPKXuEfhgfcSbqLxmESm38aRais4kfToUCv1L2Lv7iKQdQjaztqoQc%2Bd7e1znhQQKEIbX2jCE2R7Kww0dtuM%2Bgefdma2G4vlf7IM/r0tQiJ2o1yUywNaIZ1ytAE5b73eseSHej4kepn6J9U7bGnRxkkdlrU%2BhMzhhaiz8rFAThEeldQoZZK6NwpcE1VubFLjqYkcNjXA6CrbVhlDqVCp1rjnGNiVkgF/Af%2BytJY0nuiJLiHC44Hfpd%2BIBoqpqKXSgoWfQoB/ScF%2B9Z/63jtkKttixGvisdU5uVsT%2BPZ4U34ALNyqjE40o%2BwlxGm1%2BssGhtz96q23cJJdY0fZCFoEef%2BcGUYFMq2Ypu2sIA1/LtPL5YM%2BJ1FA7UvVMd5%2BxsuwZYH7ap5p4h/qBAC8qncd8PHU/rlpi1lyi/1bZ4tPNHu16pBW476nwvUqxIlUoeyT06sKPUfVdB434pDH9V99rgOI2jZnUSRWxBTkmY5sV7lInYgx/pG%2BQ923ekKDSsjky6c41Kxm0kvCjNB/4c80WgXRlNM7TAmcbqUmajCpg7OxXxzrmg/Jb5EG7Y7oonmEA3pWBM6/nbdKhVtsDuIVv4LHwzwPYn4WobX35rNxFr9/tNvV%2BlVBLeYGDEuEKd3XZyn/3Z7e7Tn6QYPq9TO/XaeqwJnTOxB3LmRSm6H7vsgSmes5F%2B0VEwHiFQUJ1Z%2BTzhwN5inHf0XBnbzyqnPHIh2pb4Ioe6Xx4mFNBNKHRhW7HC8fAYHlpPh9PIR0vp0Lc9AvdHqi1rh4rTgHc/pzRIU6s1h2AH8U9nf6dvWmqsGsFNsH";
        Map<String,Object> map = new HashMap<>();
        Map<String,String> header = new HashMap<>();
        String param = FileUtil.readString("/Users/didi/IdeaProjects/lastTime/src/main/java/com/test/login.json","utf-8");
        JSONObject jsonObject = JSON.parseObject(param);
        for(String key:jsonObject.keySet()){
            map.put(key,map.get(key));
        }
        header.put("secdd-challenge","2,com.xiaojukeji.esp.inhouse|1.0.0||||||");
        header.put("Accept","*/*");
        header.put("NetLib","OKNet,AF3,0.1.1");
        header.put("secdd-authentication","51aec3a92b26c5020e3f4d29a52e88bb77614edbd69c5f192423e4f75d4dc54a946ea9f600533ca6ff9b7fee03120f7b379fa4438c01000001000000");
        header.put("didi-header-rid","ac189dc6657192a9b102637b107e0803");
        header.put("Content-Type","application/x-www-form-urlencoded");
        header.put("didi-header-hint-content","{\"urbo\":1}");
        header.put("Accept-Language","zh-Hans;q=1");
        header.put("wsgsig","dd04-QI2rINZxahPcYRmzB7uVt2RNZS0vKGsFVYwvGYA8WQRutkuOp2zOKbcMuxShAoRnx9XmXi5CZMOqW9K0cd5hVWIBGardbaw7fE0mElVEYh2L9CLigckbQfcYw7AL7NRIdtOLZbE3FqY+87pNGq+OXbAawB2777cidhEvRoRe");
        String result = HttpRequest.get(url)
//                .addHeaders(header)
//                .form(map)
//                .body(param)
                .execute()
                .body();
        System.out.println(result);
    }

    public static String convertToMd5(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String uname = convertToMd5("00016204527");
        System.out.println(uname);
    }
}
