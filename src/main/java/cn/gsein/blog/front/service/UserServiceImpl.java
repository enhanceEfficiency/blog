package cn.gsein.blog.front.service;

import cn.gsein.blog.front.mapper.UserMapper;
import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.model.User;
import cn.gsein.blog.front.util.EncryptUtil;
import cn.gsein.blog.front.util.ResultInfoFactory;
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

    @Override
    public ResultInfo<Object> saveUser(String username, String password) {

        try {
            User user = findByUsername(username);
            if(user != null){
                return ResultInfoFactory.getErrorResultInfo("该用户名已被注册！");
            }
            user = User.builder().username(username).password(EncryptUtil.md5(password)).avatarUrl("/images/avatar/avatar_default.png").build();
            userMapper.save(user);
            return ResultInfoFactory.getSuccessResultInfo("注册成功！", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfoFactory.getErrorResultInfo("发生异常，注册失败");
        }
    }
}
