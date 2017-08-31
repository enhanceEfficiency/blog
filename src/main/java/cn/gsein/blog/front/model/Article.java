package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("article")
public class Article{
    private String id;
    private List<Tag> tags;
    private Category category;
    private Integer views; //浏览量
    private String title;
    private String digest; //摘要
    private String content;
    private String pictureUrl; //文章图片的地址
    private Timestamp publishTime;
    private User author;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String status; //0-正常 1-删除
}
