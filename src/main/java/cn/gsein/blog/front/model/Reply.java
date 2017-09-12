package cn.gsein.blog.front.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/8/29.
 * 评论的回复，即楼中楼
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Reply {
    private String id;
    private String title;
    private String content;
    private Date publishTime;
    private User author;
    private Comment comment; //属于哪条评论
    private Integer floor; //楼中第几楼
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String status; //0-正常 1-删除
}
