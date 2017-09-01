package cn.gsein.blog.back.service;

import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Category;
import cn.gsein.blog.front.model.Tag;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/1.
 */
public interface AdminArticleService {
    List<Article> loadArticles(Map<String, Object> params);

    int getTotalArticleCount();

    int getArticleCount(Map<String, Object> params);

    List<Category> loadAllCategories();

    List<Tag> loadAllTags();
}
