package cn.gsein.blog.websiteinfomanager.entity;

import cn.gsein.blog.usermanager.entity.Administrator;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 */
public class WebsiteInfoManage {
    private Administrator administrator;
    private WebsiteInfo websiteInfo;
    private Timestamp time;
    private String operationType;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public WebsiteInfo getWebsiteInfo() {
        return websiteInfo;
    }

    public void setWebsiteInfo(WebsiteInfo websiteInfo) {
        this.websiteInfo = websiteInfo;
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
