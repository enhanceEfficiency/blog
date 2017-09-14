package cn.gsein.blog.front.service;

import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.model.User;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
public interface UserService {
    User findByUsername(String username);

    ResultInfo<Object> saveUser(String username, String password);
}
