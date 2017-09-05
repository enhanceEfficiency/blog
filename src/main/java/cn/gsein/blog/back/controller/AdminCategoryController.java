package cn.gsein.blog.back.controller;

import cn.gsein.blog.back.service.AdminArticleService;
import cn.gsein.blog.back.service.AdminCategoryService;
import cn.gsein.blog.front.model.Category;
import cn.gsein.blog.front.model.Pager;
import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.util.ResultInfoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/5.
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    @Resource
    private AdminCategoryService adminCategoryService;

    @Resource
    private AdminArticleService adminArticleService;

    private Logger log = LoggerFactory.getLogger(AdminCategoryController.class);

    @ResponseBody
    @RequestMapping("/initPage")
    public Pager<Category> initPage(Integer page, String categoryName) {
        Pager<Category> pager = Pager.<Category>builder().page(page).limit(10).build();
        int totalCount = adminCategoryService.getTotalCountByCategoryName(categoryName);
        pager.setTotalCount(totalCount);
        pager.setTotalPageNum((totalCount - 1) / pager.getLimit() + 1);
        return pager;
    }

    @RequestMapping("/load")
    public String load(Integer page, String categoryName, Model model) {
        Map<String, Object> params = new HashMap<>();
        Pager<Category> pager = Pager.<Category>builder().page(page).limit(10).build();
        pager.setStart((page - 1) * pager.getLimit());
        params.put("pager", pager);
        params.put("categoryName", categoryName);
        List<Category> categoryList = adminCategoryService.loadCategories(params);
        model.addAttribute("categoryList", categoryList);
        return "/admin/category/categoryTable";
    }

    @ResponseBody
    @RequestMapping("/save")
    public ResultInfo<Object> save(Category category) {
        try {
            category.setName(URLDecoder.decode(category.getName(), "utf-8"));
            adminCategoryService.saveCategory(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("保存分类失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("保存分类成功！", null);
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultInfo<Object> update(Category category) {
        try {
            String id = URLDecoder.decode(category.getId(), "utf-8");
            Category queriedCategory = adminCategoryService.loadCategory(id);
            queriedCategory.setName(URLDecoder.decode(category.getName(), "utf-8"));
            adminCategoryService.updateCategory(queriedCategory);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("修改分类失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("修改分类成功！", null);
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public ResultInfo<Object> delete(@PathVariable String id) {
        try {
            adminCategoryService.deleteCategory(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("删除分类失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("删除分类成功！", null);
    }

    @ResponseBody
    @RequestMapping("/query/{id}")
    public ResultInfo<Object> query(@PathVariable String id) {
        int count = adminArticleService.getArticleCountByCategoryId(id);
        if (count > 0) {
            return ResultInfoFactory.getErrorResultInfo("分类有文章使用！");
        } else {
            return ResultInfoFactory.getSuccessResultInfo("分类无文章使用！", null);
        }
    }

}
