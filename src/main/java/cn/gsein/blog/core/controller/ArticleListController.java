package cn.gsein.blog.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by G.Seinfeld on 2017/5/19.
 * 文章列表页的控制器
 */
@Controller
public class ArticleListController {

    /**
     * 跳转至文章列表页
     * @return 文章列表页URL
     */
    @RequestMapping("toArticleList.do")
    public String toArticleList(){
        return "core/template/article_list";
    }
}
