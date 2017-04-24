package cn.gsein.blog.test.usermanager.mapper;

import cn.gsein.blog.base.entity.PageAndOrder;
import cn.gsein.blog.test.base.BaseTest;
import cn.gsein.blog.usermanager.entity.User;
import cn.gsein.blog.usermanager.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;

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
        User user = new User();
        user.setId("188");
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
