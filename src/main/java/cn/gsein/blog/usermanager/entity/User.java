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
    private String userId;
    /**
     * 账号
     */
    private String userAccount;
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
    private String avatarUrl;
    /**
     * 手机号码
     */
    private String mobileNumber;
    /**
     * 注册时间
     */
    private Timestamp registerDate;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 发表的文章
     */
    private List<Article> articles;
    /**
     * 权限
     */
    private String authority;

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
