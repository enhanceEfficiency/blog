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

    /**
     * 测试插入用户
     * 2017/05/09 测试通过 成功插入数据
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setUserId("188");
        user.setUserAccount("lhing17");
        user.setLevel(0);
        user.setPoint(100);
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
