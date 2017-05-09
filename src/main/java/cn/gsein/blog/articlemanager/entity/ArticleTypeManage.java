package cn.gsein.blog.articlemanager.entity;

import cn.gsein.blog.usermanager.entity.Administrator;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 文章分类管理——管理员与文章分类间的关系
 */
public class ArticleTypeManage {
    private Administrator administrator;
    private ArticleType articleType;
    private Timestamp time;
    private String operationType;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
