package cn.gsein.blog.usermanager.mapper;

import cn.gsein.blog.base.mapper.BaseMapper;
import cn.gsein.blog.usermanager.entity.Administrator;
import org.springframework.stereotype.Repository;

/**
 * Created by G.Seinfeld on 2017/5/18.
 * 管理员Mapper
 */
@Repository
public interface AdministratorMapper extends BaseMapper<Administrator, Integer> {
    Administrator queryByUserAccount(String userAccount);
}
