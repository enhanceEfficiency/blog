package cn.gsein.blog.templatemanager.entity;

import cn.gsein.blog.usermanager.entity.Administrator;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 模板管理——模板与管理员间的关系
 */
public class TemplateManage {
    private Administrator administrator;
    private Template template;
    private Timestamp time;
    private String operationType;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
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
