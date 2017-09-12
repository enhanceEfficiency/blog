package cn.gsein.blog.front.util;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
public class IpUtilTest {
    @Test
    public void sendPostForSearchingIp() throws Exception {
        JSONObject object = IpUtil.sendPostForSearchingIp("222.169.231.36");
        System.out.println(object);
    }

}