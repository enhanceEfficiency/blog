package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Data
@Builder
@NoArgsConstructor
@Alias("category")
@AllArgsConstructor
public class Category {
    private String id;
    private String name;
    private String status;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
}
