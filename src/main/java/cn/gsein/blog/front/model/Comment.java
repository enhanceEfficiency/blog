package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Alias("comment")
public class Comment {
    private String id;
    private String content; // 评论内容
    private Timestamp publishTime; // 发布时间
    private String authorId; // 作者ID
    private String username; // 作者用户名
    private String avatarUrl; // 作者头像url
    private String ip;
    private String articleId; // 当前文章ID
    private Integer floor; //楼层
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String status; //0-正常 1-删除
}
