package cn.gsein.blog.articlemanager.mapper;

import cn.gsein.blog.articlemanager.entity.Article;
import cn.gsein.blog.base.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 文章映射
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article, Integer> {

    List<Article> queryByUserId(Integer userId);
}
