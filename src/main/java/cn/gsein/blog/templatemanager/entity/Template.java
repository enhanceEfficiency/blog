package cn.gsein.blog.templatemanager.entity;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 模板
 */
public class Template {
    private String templateId;
    private String name;
    private String url;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
