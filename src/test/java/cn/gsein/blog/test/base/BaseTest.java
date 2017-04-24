package cn.gsein.blog.test.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by G.Seinfeld on 2017/4/20.
 */
public class BaseTest {
    public ClassPathXmlApplicationContext getContext(){
        return new ClassPathXmlApplicationContext(new String[]{"spring-mvc.xml", "spring-mybatis.xml"});
    }
}
