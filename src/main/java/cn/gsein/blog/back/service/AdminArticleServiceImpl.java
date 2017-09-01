package cn.gsein.blog.back.service;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CategoryMapper;
import cn.gsein.blog.front.mapper.TagMapper;
import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Category;
import cn.gsein.blog.front.model.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<Category> loadAllCategories(){
        return categoryMapper.findAll();
    }

    @Override
    public List<Tag> loadAllTags(){
        return tagMapper.findAll();
    }
}
