package cn.gsein.blog.core.service;

import cn.gsein.blog.base.entity.JsonResult;
import cn.gsein.blog.usermanager.entity.Administrator;

/**
 * Created by G.Seinfeld on 2017/5/18.
 */
public interface CmsLoginService {
    public JsonResult<Administrator> checkLogin(Administrator administrator);
}
