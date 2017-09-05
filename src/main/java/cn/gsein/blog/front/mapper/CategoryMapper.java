package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/1.
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    int findTotalCountByName(String categoryName);

    List<Category> findByParams(Map<String, Object> params);
}
