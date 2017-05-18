package cn.gsein.blog.usermanager.service;

import cn.gsein.blog.base.entity.PageAndOrder;
import cn.gsein.blog.usermanager.entity.User;
import cn.gsein.blog.usermanager.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 */
@Service("userManagerService")
public class UserManagerServiceImpl implements UserManagerService {

    @Resource
    private UserMapper userMapper;

    public List<User> findByPageAndOrder(Integer rowsPerPage, String pageIndex, String orderField) {
        int pageIndexInt = new Integer(pageIndex);
        PageAndOrder pao = new PageAndOrder((pageIndexInt-1)*rowsPerPage, rowsPerPage, orderField);
        return userMapper.queryAllByPageAndOrder(pao);
    }

    public Integer queryCount() {
        return userMapper.queryCount();
    }

}
