package cn.gsein.blog.usermanager.entity;

import cn.gsein.blog.articlemanager.entity.Article;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * 博客用户实体类
 */
public class User {
    /**
     * 主键，区分不同用户的唯一标识
     */
    private String id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 积分
     */
    private Integer point;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 头像的URL
     */
    private String imageUrl;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 注册时间
     */
    private Timestamp registerTime;
    /**
     * 发表的文章
     */
    private List<Article> articles;

    public User() {

    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", point=" + point +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
