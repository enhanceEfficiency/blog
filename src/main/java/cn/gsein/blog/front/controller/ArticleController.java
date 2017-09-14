package cn.gsein.blog.front.controller;

import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.service.ArticleService;
import cn.gsein.blog.front.util.RequestInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping("/comment")
    public ResultInfo<Object> comment(HttpServletRequest request, String id, String username, String commentBody, Model model) {
        String ip = RequestInfoUtil.getRemoteHost(request);
        //model.addAttribute("commentList", articleService.getAllCommentsOfArticle(id));
        return articleService.saveComment(ip, id, username, commentBody);
    }


}
