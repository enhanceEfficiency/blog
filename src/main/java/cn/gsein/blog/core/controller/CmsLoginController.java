package cn.gsein.blog.core.controller;

import cn.gsein.blog.base.entity.JsonResult;
import cn.gsein.blog.core.service.CmsLoginService;
import cn.gsein.blog.usermanager.entity.Administrator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/5/17.
 * 后台登录请求Controller
 */
@Controller
public class CmsLoginController {

    @Resource
    private CmsLoginService cmsLoginService;

    @RequestMapping("toCmsLogin.do")
    public String toLogin() {

        return "admin/login/login";
    }

    /**
     * 管理员登录后台
     *
     * @return 登录后跳转页面
     */
    @RequestMapping("cmsLogin.do")
    @ResponseBody
    public JsonResult<Administrator> login(HttpSession session, Administrator administrator) {

        JsonResult<Administrator> result = cmsLoginService.checkLogin(administrator);
        if("200".equals(result.getCode())){
            session.setAttribute("loginUser", administrator);
        }
        return result;
    }
}
