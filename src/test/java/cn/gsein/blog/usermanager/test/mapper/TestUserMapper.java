package cn.gsein.blog.usermanager.test.mapper;

import cn.gsein.blog.base.entity.PageAndOrder;
import cn.gsein.blog.usermanager.entity.User;
import cn.gsein.blog.usermanager.mapper.UserMapper;
import cn.gsein.blog.usermanager.test.base.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 用户持久层的测试类
 */
public class TestUserMapper extends BaseTest {

    private UserMapper userMapper;

    @Before
    public void init() {
        userMapper = getContext().getBean("userMapper", UserMapper.class);
        getContext().close();
    }

    @Test
    public void testInsert() {
        User user = new User("125", "Jack Ma", "123456", 300, "13322423433", new Timestamp(new Date().getTime()));
        userMapper.insert(user);
    }

    @Test
    public void testQueryAll() {
        List<User> users = userMapper.queryAll();
        for (User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testQueryAllByPageAndOrder(){
        List<User> users = userMapper.queryAllByPageAndOrder(new PageAndOrder(0, 5, "point desc" ));
        for (User user: users){
            System.out.println(user);
        }
    }

}
