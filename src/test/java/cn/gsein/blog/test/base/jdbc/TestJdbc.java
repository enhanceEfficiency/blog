package cn.gsein.blog.test.base.jdbc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * Created by G.Seinfeld on 2017/4/19.
 * Jdbc测试类，测试jdbc是否有效连接
 */
public class TestJdbc {
    private DefaultSqlSessionFactory ssfb;
    @Before
    public void init(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ssfb = ctx.getBean("sqlSessionFactory", DefaultSqlSessionFactory.class);
        ctx.close();
    }

    /**
     * 2017/05/09 测试通过 输出jdbc:mysql://localhost:3306/seinfeld?serverTimezone=UTC&characterEncoding=utf8&useSSL=true, UserName=root@, MySQL Connector Java
     */
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
