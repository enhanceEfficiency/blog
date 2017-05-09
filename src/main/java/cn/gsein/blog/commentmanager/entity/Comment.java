package cn.gsein.blog.commentmanager.entity;

import cn.gsein.blog.articlemanager.entity.Article;
import cn.gsein.blog.usermanager.entity.User;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 评论实体类
 */
public class Comment {
    private String commentId;
    private Article article;
    private User use;
    private String content;
    private Timestamp publishTime;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUse() {
        return use;
    }

    public void setUse(User use) {
        this.use = use;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }
}
