package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/9/11.
 * Gsein的大事记管理
 */
@Alias("memorabilia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Memorabilia {
    private String id;
    private Date eventTime;
    private String eventDescription;
    private String status;
    private Timestamp createTime;
    private Timestamp updateTime;
}
