package cn.gsein.blog.front.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {
    private String id;
    private String title;
    private String content;
    private Date publishTime;
    private User Author;
    private Article article;
    private Integer floor; //楼层
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String status; //0-正常 1-删除
}
