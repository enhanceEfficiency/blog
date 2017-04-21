package cn.gsein.blog.usermanager.test.service;

import cn.gsein.blog.usermanager.entity.User;
import cn.gsein.blog.usermanager.service.UserManagerService;
import cn.gsein.blog.usermanager.test.base.BaseTest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 */
public class TestUserManagerService extends BaseTest {
    private UserManagerService userManagerService;

    @Before
    public void init() {
        userManagerService = getContext().getBean("userManagerService", UserManagerService.class);
        getContext().close();
    }

    @Test
    public void testFindByPageAndOrder() {
        List<User> users = userManagerService.findByPageAndOrder(10, "1", "point desc");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
