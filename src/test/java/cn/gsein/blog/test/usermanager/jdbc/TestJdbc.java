package cn.gsein.blog.test.usermanager.jdbc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * Jdbc测试类
 */
public class TestJdbc {
    private DefaultSqlSessionFactory ssfb;
    @Before
    public void init(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ssfb = ctx.getBean("sqlSessionFactory", DefaultSqlSessionFactory.class);
        ctx.close();
    }

    @Test
    public void testMyBatisSqlSessionFactory(){
        try {
            SqlSession ss = ssfb.openSession();
            Connection conn = ss.getConnection();
            System.out.println(conn);
            conn.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
