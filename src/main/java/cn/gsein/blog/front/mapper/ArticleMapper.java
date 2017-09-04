package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> findByParams(Map<String, Object> params);

    int findCountByParams(Map<String, Object> params);

    int saveArticleTags(Map<String, Object> params);

    int deleteArticleTags(String id);
}
