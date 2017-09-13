package cn.gsein.blog.front.util;

import org.junit.Test;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
public class IpUtilTest {
    @Test
    public void sendPostForSearchingIp() throws Exception {
        String city = IpUtil.getCityByIp("222.169.231.36");
        System.out.println(city);
    }

}