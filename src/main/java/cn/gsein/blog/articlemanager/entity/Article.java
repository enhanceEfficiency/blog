package cn.gsein.blog.articlemanager.entity;

import cn.gsein.blog.usermanager.entity.User;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/4/24.
 * 博客上的文章实体类
 */
public class Article {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 作者
     */
    private User author;
    /**
     * 发表时间
     */
    private Timestamp publishTime;
    /**
     * 阅读量
     */
    private Integer readingAmount;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getReadingAmount() {
        return readingAmount;
    }

    public void setReadingAmount(Integer readingAmount) {
        this.readingAmount = readingAmount;
    }
}
