package cn.gsein.blog.front.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Data
@Builder
@AllArgsConstructor
@Alias("tag")
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Tag {
    private String id;
    private String name;
    private String status;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
}
