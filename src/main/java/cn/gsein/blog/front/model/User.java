package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }
}
