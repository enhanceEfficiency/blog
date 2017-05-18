package cn.gsein.blog.core.service;

import cn.gsein.blog.base.entity.JsonResult;
import cn.gsein.blog.usermanager.mapper.AdministratorMapper;
import cn.gsein.blog.usermanager.entity.Administrator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/5/18.
 * 后台登陆的Service层
 */
@Service("cmsLoginService")
public class CmsLoginServiceImpl implements CmsLoginService {

    @Resource
    private AdministratorMapper administratorMapper;

    public JsonResult<Administrator> checkLogin(Administrator administrator) {
        Administrator resultAdministrator = administratorMapper.queryByUserAccount(administrator.getUserAccount());
        JsonResult<Administrator> result = new JsonResult<Administrator>();
        if(resultAdministrator==null){
            result.setCode("100");
            result.setMessage("用户名或密码错误");
            return result;
        }else {
            result.setCode("200");
            result.setMessage("登录成功");
            result.setData(resultAdministrator);
            return result;
        }
    }
}
