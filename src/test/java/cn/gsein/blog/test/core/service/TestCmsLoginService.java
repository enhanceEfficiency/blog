package cn.gsein.blog.test.core.service;

import cn.gsein.blog.base.entity.JsonResult;
import cn.gsein.blog.core.service.CmsLoginService;
import cn.gsein.blog.test.base.BaseTest;
import cn.gsein.blog.usermanager.entity.Administrator;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by G.Seinfeld on 2017/5/18.
 */
public class TestCmsLoginService extends BaseTest {
    private CmsLoginService cmsLoginService;

    @Before
    public void init() {
        cmsLoginService = getContext().getBean("cmsLoginService", CmsLoginService.class);
        getContext().close();
    }

    /**
     * 测试登陆检验
     * 2017/05/18
     * 测试通过 登录失败+登录成功
     */
    @Test
    public void testCheckLogin() {
        /*
        登录失败 用户名或密码错误
         */
        Administrator admin = new Administrator();
        admin.setUserAccount("lhing18");
        admin.setPassword("l1234567");
        JsonResult<Administrator> result = cmsLoginService.checkLogin(admin);
        System.out.println(result);
        /*
        登录成功
         */
        Administrator admin2 = new Administrator();
        admin2.setUserAccount("lhing17");
        admin2.setPassword("1357924680");
        result = cmsLoginService.checkLogin(admin2);
        System.out.println(result);

    }
}
