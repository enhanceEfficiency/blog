package cn.gsein.blog.articlemanager.entity;

/**
 * 文章类型
 * G.Seinfeld 2017/05/05
 */
public class ArticleType {
    /**
     * 文章类型id
     */
    private String articleTypeId;
    /**
     * 文章类型名称
     */
    private String type;

    public String getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(String articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}