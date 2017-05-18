package cn.gsein.blog.usermanager.mapper;

import cn.gsein.blog.base.mapper.BaseMapper;
import cn.gsein.blog.usermanager.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 用户映射
 */
@Repository
public interface UserMapper extends BaseMapper<User, Integer>{
    User queryByUserAccount(String userAccount);
}
