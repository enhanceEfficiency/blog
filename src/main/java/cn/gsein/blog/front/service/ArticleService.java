package cn.gsein.blog.front.service;

import cn.gsein.blog.front.model.Comment;
import cn.gsein.blog.front.model.ResultInfo;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
public interface ArticleService {
    /**
     * 保存评论
     * @param ip 请求者的ip地址
     * @param articleId 文章id
     * @param username 用户名
     * @param commentBody 评论内容
     * @return 评论是否成功
     */
    ResultInfo<Object> saveComment(String ip, String articleId, String username, String commentBody);

    /**
     * 获取某篇文章所有的评论
     * @param articleId 文章ID
     * @return 文章评论列表
     */
    List<Comment> getAllCommentsOfArticle(String articleId);
}
