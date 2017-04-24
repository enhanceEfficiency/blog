package cn.gsein.blog.usermanager.controller;

import cn.gsein.blog.usermanager.entity.User;
import cn.gsein.blog.usermanager.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 用户管理的控制器
 */
@Controller
public class UserManagerController {

    @Resource
    private UserManagerService userManagerService;

    @RequestMapping("toUserManager.do")
    public String toUserManager(HttpServletRequest request){
        List<User> users = userManagerService.findByPageAndOrder(10, "1", "");
        Integer pageNum = (userManagerService.queryCount()-1)/10+1;
        request.setAttribute("users", users);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("currentPage", 1);
        return "admin/usermanager/UserManager";
    }

    @RequestMapping("UserManager.do")
    public String UserManager(Integer rowsPerPage, String pageIndex, String orderField, HttpServletRequest request){
        List<User> users = userManagerService.findByPageAndOrder(rowsPerPage, pageIndex, orderField);
        Integer pageNum = (userManagerService.queryCount()-1)/rowsPerPage+1;
        request.setAttribute("users", users);
        request.setAttribute("orderField", orderField);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("currentPage", pageIndex);

        return "admin/usermanager/UserManager";
    }

}
