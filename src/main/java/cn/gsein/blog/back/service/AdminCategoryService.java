package cn.gsein.blog.back.service;

import cn.gsein.blog.front.model.Category;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/5.
 */
public interface AdminCategoryService {
    int getTotalCountByCategoryName(String categoryName);

    List<Category> loadCategories(Map<String, Object> params);

    void saveCategory(Category category);

    void deleteCategory(String id);

    void updateCategory(Category category);

    Category loadCategory(String id);
}
