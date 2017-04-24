package cn.gsein.blog.base.service;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 */
public interface BaseService<T> {
    List<T> findByPageAndOrder(Integer rowsPerPage, String pageIndex, String orderField);
    Integer queryCount();
}
