package cn.gsein.blog.front.controller;

import cn.gsein.blog.front.mapper.ArticleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/8/28.
 */
@Controller
public class PageController {

    @Resource
    private ArticleMapper articleMapper;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("articles", articleMapper.findAll()); // 所有文章
        return "index";
    }

    @RequestMapping("/article/{id}")
    public String article(@PathVariable String id, Model model){
        model.addAttribute("article", articleMapper.findById(id)); // 所有文章
        return "article";
    }
}
