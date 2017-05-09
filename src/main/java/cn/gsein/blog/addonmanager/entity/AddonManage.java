package cn.gsein.blog.addonmanager.entity;

import cn.gsein.blog.usermanager.entity.Administrator;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 插件管理——插件和管理员间的关系
 */
public class AddonManage {
    private Addon addon;
    private Administrator administrator;
    private Timestamp time;
    private String operationType;

    public Addon getAddon() {
        return addon;
    }

    public void setAddon(Addon addon) {
        this.addon = addon;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
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
