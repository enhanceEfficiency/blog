package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * Created by G.Seinfeld on 2017/9/11.
 * 请求记录
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("requestRecord")
public class RequestRecord {
    private String id;
    private String ipAddress;
    private String url;
    private Timestamp requestTime;
}
