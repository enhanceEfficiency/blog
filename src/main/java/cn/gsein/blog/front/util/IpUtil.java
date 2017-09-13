package cn.gsein.blog.front.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
public class IpUtil {
    private static JSONObject sendPostForSearchingIp(String ip) {
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            URLConnection connection = url.openConnection();
            connection.connect();
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JSONObject.parseObject(result.toString());
    }

    private static String getCity(JSONObject ipResult){
        return ipResult.getJSONObject("data").getString("city");
    }

    public static String getCityByIp(String ip){
        JSONObject ipResult = sendPostForSearchingIp(ip);
        return getCity(ipResult);
    }
}
