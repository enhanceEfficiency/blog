package cn.gsein.blog.back.controller;

import cn.gsein.blog.front.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping("/login")
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/article/list")
    public String toIndex(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        model.addAttribute("user", user);
        return "admin/article/articleList";
    }

}
