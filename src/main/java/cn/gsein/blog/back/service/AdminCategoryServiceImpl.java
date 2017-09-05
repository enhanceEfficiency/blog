package cn.gsein.blog.back.service;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CategoryMapper;
import cn.gsein.blog.front.model.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/5.
 */
@Service("adminCategoryService")
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public int getTotalCountByCategoryName(String categoryName) {
        return categoryMapper.findTotalCountByName(categoryName);
    }

    @Override
    public List<Category> loadCategories(Map<String, Object> params) {
        return categoryMapper.findByParams(params);
    }

    @Override
    public void saveCategory(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryMapper.deleteById(id);
        articleMapper.updateCategoryId(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public Category loadCategory(String id) {
        return categoryMapper.findById(id);
    }
}
