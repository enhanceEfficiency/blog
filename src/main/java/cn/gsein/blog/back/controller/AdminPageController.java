package cn.gsein.blog.back.controller;

import cn.gsein.blog.back.service.AdminArticleService;
import cn.gsein.blog.back.service.AdminCategoryService;
import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Category;
import cn.gsein.blog.front.model.Tag;
import cn.gsein.blog.front.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Resource
    private AdminArticleService adminArticleService;

    @Resource
    private AdminCategoryService adminCategoryService;

    @RequestMapping("/login")
    public String toLogin() {
        return "admin/login";
    }

    @RequestMapping("/article/list")
    public String toIndex(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Category> categoryList = adminArticleService.loadAllCategories();
        List<Tag> tagList = adminArticleService.loadAllTags();
        model.addAttribute("user", user);
        model.addAttribute("tagList", tagList);
        model.addAttribute("categoryList", categoryList);
        return "admin/article/articleList";
    }

    @RequestMapping("/article/addPage")
    public String toAddArticlePage() {
        return "admin/article/articleAdd";
    }

    @RequestMapping("/article/edit")
    public String toEditArticlePage(Model model, String id) {
        Article article = adminArticleService.loadArticle(id);
        model.addAttribute("article", article);
        return "admin/article/articleEdit";
    }

    @RequestMapping("/tag/list")
    public String toTagList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Tag> tagList = adminArticleService.loadAllTags();
        model.addAttribute("user", user);
        model.addAttribute("tagList", tagList);
        return "admin/label/labelList";
    }

    @RequestMapping("/category/list")
    public String toCategoryList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Category> categoryList = adminArticleService.loadAllCategories();
        model.addAttribute("user", user);
        model.addAttribute("categoryList", categoryList);
        return "admin/category/categoryList";
    }

    @RequestMapping("/category/addPage")
    public String toAddCategoryPage(){
        return "admin/category/categoryAdd";
    }

    @RequestMapping("/category/editPage/{id}")
    public String toEditCategoryPage(@PathVariable String id, Model model){
        Category category = adminCategoryService.loadCategory(id);
        model.addAttribute("category", category);
        return "admin/category/categoryEdit";
    }
}
