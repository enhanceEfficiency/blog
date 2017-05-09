package cn.gsein.blog.articlemanager.entity;

import cn.gsein.blog.usermanager.entity.Administrator;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 文章管理——文章和管理员间的关系
 */
public class ArticleManage {
    private Administrator administrator;
    private Article article;
    private Timestamp time;
    private String reason;
    private String operationType;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
