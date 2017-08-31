package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 查找到的用户，没有该用户则返回null
     */
    User findByUsername(String username);
}
