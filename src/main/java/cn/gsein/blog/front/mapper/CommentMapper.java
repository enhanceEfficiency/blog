package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**eated by G.Seinfeld on 2017/9/12.
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    int findCountByArticleId(String articleId);

    List<Comment> findByArticleId(String articleId);
}
