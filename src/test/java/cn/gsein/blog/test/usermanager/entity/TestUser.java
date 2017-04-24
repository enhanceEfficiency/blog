package cn.gsein.blog.test.usermanager.entity;

import cn.gsein.blog.usermanager.entity.User;
import org.junit.Test;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * User的测试类
 */
public class TestUser {

    @Test
    public void testToString(){
        User user = new User();
        System.out.println(user);
    }
}
