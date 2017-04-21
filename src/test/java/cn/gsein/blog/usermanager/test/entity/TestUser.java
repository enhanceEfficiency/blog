package cn.gsein.blog.usermanager.test.entity;

import cn.gsein.blog.usermanager.entity.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * User的测试类
 */
public class TestUser {

    @Test
    public void testToString(){
        User user = new User("123","zhangsan", "123456", 50, "13333333333", new Timestamp(new Date().getTime()));
        System.out.println(user);
    }
}
