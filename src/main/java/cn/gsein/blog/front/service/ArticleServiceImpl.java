package cn.gsein.blog.front.service;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CommentMapper;
import cn.gsein.blog.front.mapper.UserMapper;
import cn.gsein.blog.front.model.Comment;
import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.model.User;
import cn.gsein.blog.front.util.ResultInfoFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CommentMapper commentMapper;

    @Override
    public ResultInfo<Object> saveComment(String ip, String articleId, String username, String commentBody) {
        /*
        查用户
         */
        User user = userMapper.findByUsername(username);
        if (user == null) { //用户不存在
            user = User.builder().username(username).password(null).avatarUrl("/images/avatar/avatar_default.png").build();
            userMapper.save(user);
        }
        /*
        存评论
         */
        Integer floor = commentMapper.findCountByArticleId(articleId) + 1;
        Comment comment = Comment.builder().content(commentBody).authorId(user.getId()).articleId(articleId).ip(ip).floor(floor).build();
        int result = commentMapper.save(comment);
        if (result == 1){
            return ResultInfoFactory.getSuccessResultInfo("评论成功！", null);
        }
        return ResultInfoFactory.getErrorResultInfo("评论失败");
    }

    @Override
    public List<Comment> getAllCommentsOfArticle(String articleId) {
        return commentMapper.findByArticleId(articleId);
    }
}
