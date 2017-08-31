package cn.gsein.blog.front.service;

import cn.gsein.blog.front.mapper.UserMapper;
import cn.gsein.blog.front.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
