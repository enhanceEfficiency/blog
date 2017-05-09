package cn.gsein.blog.websiteinfomanager.entity;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 网站信息
 */
public class WebsiteInfo {
    private String websiteInfoId;
    private String name;
    private String content;

    public String getWebsiteInfoId() {
        return websiteInfoId;
    }

    public void setWebsiteInfoId(String websiteInfoId) {
        this.websiteInfoId = websiteInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
