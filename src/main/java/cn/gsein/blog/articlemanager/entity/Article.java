package cn.gsein.blog.articlemanager.entity;

import cn.gsein.blog.usermanager.entity.User;

import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/4/24.
 * 博客上的文章实体类
 */
public class Article {
    /**
     * 文章id
     */
    private String articleId;
    /**
     * 作者
     */
    private User user;
    /**
     * 文章类型
     */
    private ArticleType articleType;
    /**
     * 标题
     */
    private String title;
    /**
     * 发表时间
     */
    private Date publishTime;
    /**
     * 内容
     */
    private String content;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
               //", userId=" + user.getUserId() +
                ", articleType=" + articleType +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", content='" + content + '\'' +
                '}';
    }
}