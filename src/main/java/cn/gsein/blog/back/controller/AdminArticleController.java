package cn.gsein.blog.back.controller;

import cn.gsein.blog.back.service.AdminArticleService;
import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/8/31.
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private AdminArticleService adminArticleService;

    @RequestMapping("/initPage")
    @ResponseBody
    public Pager<Article> initPage(Pager<Article> pager, String categoryId, String title, String tagIds) {
        Map<String, Object> params = new HashMap<>();
        params.put("pager", pager);
        params.put("categoryId", categoryId);
        params.put("title", title);
        if (tagIds != null && !"".equals(tagIds)) {
            params.put("tagIds", tagIds.split(","));
        } else {
            params.put("tagIds", null);
        }
        int totalCount = adminArticleService.getArticleCount(params);
        pager.setTotalCount(totalCount);
        pager.setTotalPageNum((totalCount - 1) / pager.getLimit() + 1);
        System.out.println(pager);
        return pager;
    }

    @RequestMapping("/load")
    public String load(Pager<Article> pager, String categoryId, String title, String tagIds, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("pager", pager);
        params.put("categoryId", categoryId);
        params.put("title", title);
        if (tagIds != null && !"".equals(tagIds)) {
            params.put("tagIds", tagIds.split(","));
        } else {
            params.put("tagIds", null);
        }
        System.out.println(params);
        List<Article> articleList = adminArticleService.loadArticles(params);
        model.addAttribute("articleList", articleList);
        System.out.println(articleList);
        return "/admin/article/articleTable";
    }
}
