package cn.gsein.blog.front.controller;

import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.model.User;
import cn.gsein.blog.front.service.UserService;
import cn.gsein.blog.front.util.EncryptUtil;
import cn.gsein.blog.front.util.ResultInfoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/9/14.
 * 前台评论处登录的控制器
 */
@Controller
public class LoginAndRegisterController {

    @Resource
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultInfo<Object> login(String username, String password, HttpSession session) {
        //System.out.println(username);
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResultInfoFactory.getErrorResultInfo("用户名或密码错误");
        }
        String queriedPassword = user.getPassword();
        //System.out.println(password);
        //System.out.println(queriedPassword);
        if (password != null && EncryptUtil.md5(password).equals(queriedPassword)) {
            session.setAttribute("user", user);
            return ResultInfoFactory.getSuccessResultInfo("登录成功！", null);
        }
        return ResultInfoFactory.getErrorResultInfo("用户名或密码错误");
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResultInfo<Object> register(String username, String password) {
        return userService.saveUser(username, password);
    }
}
