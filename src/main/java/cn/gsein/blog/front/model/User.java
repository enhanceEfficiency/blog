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
@Alias("user")
@NoArgsConstructor
@AllArgsConstructor()
public class User {
    private String id; //主键
    private String username;
    private String password;
    private String avatarUrl;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;
    private String status; //0-正常 1-删除

}
