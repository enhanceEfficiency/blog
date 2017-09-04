package cn.gsein.blog.back.controller;

import cn.gsein.blog.back.service.AdminArticleService;
import cn.gsein.blog.front.model.*;
import cn.gsein.blog.front.util.ResultInfoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/8/31.
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    private Logger log = LoggerFactory.getLogger(AdminArticleController.class);

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
        //System.out.println(pager);
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
        //System.out.println(articleList);
        return "/admin/article/articleTable";
    }


    @RequestMapping("/term")
    public String articleTerm(Model model) {
        List<Tag> tagList = adminArticleService.loadAllTags();
        List<Category> categoryList = adminArticleService.loadAllCategories();
        model.addAttribute("tagList", tagList);
        model.addAttribute("categoryList", categoryList);
        return "/admin/article/articleInfo";
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResultInfo<Object> save(Article article, String categoryId, String tagIds, HttpSession session) {
        try {
            article.setCategory(new Category());
            article.getCategory().setId(categoryId);
            article.setTitle(URLDecoder.decode(article.getTitle(), "utf-8"));
            article.setContent(URLDecoder.decode(article.getContent(), "utf-8"));
            article.setDigest(URLDecoder.decode(article.getDigest(), "utf-8"));
            article.setAuthor((User) session.getAttribute("user"));
            adminArticleService.saveArticle(article, tagIds);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("保存文章失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("保存成功", null);
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(Model model, String articleId) {
        Article article = adminArticleService.loadArticle(articleId);
        List<Tag> tagList = adminArticleService.loadAllTags();
        List<Category> categoryList = adminArticleService.loadAllCategories();
        System.out.println(article.getTags());
        model.addAttribute("article", article);
        model.addAttribute("tagList", tagList);
        model.addAttribute("categoryList", categoryList);
        return "/admin/article/articleEditInfo";
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultInfo<Object> update(Article article, String categoryId, String tagIds) {
        try {
            Article queriedArticle = adminArticleService.loadArticle(article.getId());
            queriedArticle.getCategory().setId(categoryId);
            queriedArticle.setTitle(URLDecoder.decode(article.getTitle(), "utf-8"));
            queriedArticle.setContent(URLDecoder.decode(article.getContent(), "utf-8"));
            queriedArticle.setDigest(URLDecoder.decode(article.getDigest(), "utf-8"));
            adminArticleService.updateArticle(queriedArticle, tagIds);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("更新文章失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("更新成功", null);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable String id) {
        try {
            System.out.println(id);
            adminArticleService.deleteArticleById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("删除文章失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("删除成功", null);
    }
}
