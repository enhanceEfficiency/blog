package cn.gsein.blog.usermanager.entity;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * 博客用户
 */
public class User {
    private String id;
    private String account;
    private String password;
    private Integer point;
    private String phoneNumber;
    private Timestamp registerTime;

    public User() {

    }

    public User(String id, String account, String password, Integer point, String phoneNumber, Timestamp registerTime) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.point = point;
        this.phoneNumber = phoneNumber;
        this.registerTime = registerTime;
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
