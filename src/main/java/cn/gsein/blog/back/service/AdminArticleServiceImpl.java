package cn.gsein.blog.back.service;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CategoryMapper;
import cn.gsein.blog.front.mapper.TagMapper;
import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Category;
import cn.gsein.blog.front.model.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/1.
 */
@Service("adminArticleService")
public class AdminArticleServiceImpl implements AdminArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Article> loadArticles(Map<String, Object> params) {
        return articleMapper.findByParams(params);
    }

    @Override
    public int getTotalArticleCount() {
        return articleMapper.findTotalCount();
    }

    @Override
    public int getArticleCount(Map<String, Object> params) {
        return articleMapper.findCountByParams(params);
    }

    @Override
    public int getArticleCountByCategoryId(String categoryId) {
        return articleMapper.findCountByCategoryId(categoryId);
    }

    @Override
    public List<Category> loadAllCategories(){
        return categoryMapper.findAll();
    }

    @Override
    public List<Tag> loadAllTags(){
        return tagMapper.findAll();
    }

    @Override
    public void saveArticle(Article article, String tagIds) {
        articleMapper.save(article);
        saveArticleTagsIfNotNull(article, tagIds);
    }

    @Override
    public Article loadArticle(String id) {
        return articleMapper.findById(id);
    }

    @Override
    public void updateArticle(Article article, String tagIds) {
        articleMapper.update(article);
        articleMapper.deleteArticleTags(article.getId());
        saveArticleTagsIfNotNull(article, tagIds);
    }

    private void saveArticleTagsIfNotNull(Article article, String tagIds) {
        if (tagIds != null && !"".equals(tagIds) && article.getId() != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("articleId", article.getId());
            params.put("tagIds", tagIds.split(","));
            articleMapper.saveArticleTags(params);
        }
    }

    @Override
    public void deleteArticleById(String id){
        articleMapper.deleteById(id);
    }

}
