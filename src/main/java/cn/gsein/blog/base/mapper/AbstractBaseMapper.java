package cn.gsein.blog.base.mapper;

import cn.gsein.blog.base.entity.PageAndOrder;
import cn.gsein.blog.base.util.ReflectionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 实现通用mapper
 */
public abstract class AbstractBaseMapper<T, PK extends Serializable> implements BaseMapper<T, PK> {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    protected BaseMapper<T, PK> getBaseMapper() {
        SqlSession session = sqlSessionFactory.openSession();
        Class<?> entityMapperClass = ReflectionUtil.getMatcherMapper(getClass());
        return (BaseMapper<T, PK>) session.getMapper(entityMapperClass);
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insert(T entity) {
        getBaseMapper().insert(entity);
    }

    public void delete(PK primaryKey) {
        getBaseMapper().delete(primaryKey);
    }

    public void update(T entity) {
        getBaseMapper().update(entity);
    }

    public List<T> queryAll() {
        return getBaseMapper().queryAll();
    }

    public Integer queryCount() {
        return getBaseMapper().queryCount();
    }

    public List<T> queryAllByEntity(T entity) {
        return getBaseMapper().queryAllByEntity(entity);
    }

    public List<T> queryAllByPageAndOrder(PageAndOrder pao) {
        return getBaseMapper().queryAllByPageAndOrder(pao);
    }

    public T queryByPrimaryKey(PK primaryKey) {
        return getBaseMapper().queryByPrimaryKey(primaryKey);
    }
}
