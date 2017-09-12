package cn.gsein.blog.front.controller;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CommentMapper;
import cn.gsein.blog.front.mapper.MemorabiliaMapper;
import cn.gsein.blog.front.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/8/28.
 */
@Controller
public class PageController {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MemorabiliaMapper memorabiliaMapper;

    @Resource
    private CommentMapper commentMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("articles", articleMapper.findAll()); // 所有文章
        model.addAttribute("latestProgrammerArticle", articleMapper.findLatestArticleByCategoryId("9b743c67937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestGameDesignerArticle", articleMapper.findLatestArticleByCategoryId("a0df5321937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestInvestorArticle", articleMapper.findLatestArticleByCategoryId("acfbd690937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestTranslatorArticle", articleMapper.findLatestArticleByCategoryId("b10f49dd937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSix());
        return "index";
    }

    @RequestMapping("/articleList/{categoryId}")
    public String articleList(@PathVariable String categoryId, Model model) {
        model.addAttribute("articleList", articleMapper.findByCategoryId(categoryId));
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSix());
        return "articleList";
    }

    @RequestMapping("/article/{id}")
    public String article(@PathVariable String id, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("username", "匿名网友");
        } else{
            model.addAttribute("username", user.getUsername());
        }
        model.addAttribute("article", articleMapper.findById(id)); // 所有文章
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSix());
        model.addAttribute("commentList", commentMapper.findByArticleId(id));
        return "article";
    }
}
