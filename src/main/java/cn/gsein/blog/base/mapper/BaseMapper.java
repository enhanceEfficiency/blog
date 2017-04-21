package cn.gsein.blog.base.mapper;

import cn.gsein.blog.base.entity.PageAndOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 通用Mapper接口
 */
public interface BaseMapper<T, PK extends Serializable> {
    /**
     * 插入一条数据
     */
    void insert(T entity);

    /**
     * 按主键删除一条数据
     */
    void delete(PK primaryKey);

    /**
     * 更新一条数据
     */
    void update(T entity);

    /**
     * 查询所有数据
     */
    List<T> queryAll();

    /**
     * 查询数据总条数
     */
    Integer queryCount();

    /**
     * 按页查询并排序
     * @param pao 用于分布和排序功能，封装了分页的开始条数和结束条数以及排序语句
     * @return 某页排序后的所有数据
     */
    List<T> queryAllByPageAndOrder(PageAndOrder pao);

    /**
     * 按实体查询，通常是按实体的某个属性查询
     * @param entity
     */
    List<T> queryAllByEntity(T entity);

    /**
     * 按主键查询一条数据
     * @param primaryKey 主键
     */
    T queryByPrimaryKey(PK primaryKey);

}
