package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Pager;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
public interface BaseMapper<T> {

    int save(T t);

    int delete(T t);

    int deleteById(String id);

    int update(T t);

    T findById(String id);

    List<T> findByPager(Pager<T> pager);

    List<T> findAll();

    int findTotalCount();

}
