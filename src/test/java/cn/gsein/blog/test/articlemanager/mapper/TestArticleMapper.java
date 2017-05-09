package cn.gsein.blog.test.articlemanager.mapper;

import cn.gsein.blog.articlemanager.entity.Article;
import cn.gsein.blog.articlemanager.entity.ArticleType;
import cn.gsein.blog.articlemanager.mapper.ArticleMapper;
import cn.gsein.blog.test.base.BaseTest;
import cn.gsein.blog.usermanager.entity.User;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by G.Seinfeld on 2017/5/9.
 * 文章持久层的测试类
 */
public class TestArticleMapper extends BaseTest {

    private ArticleMapper articleMapper;

    @Before
    public void init() {
        articleMapper = getContext().getBean("articleMapper", ArticleMapper.class);
        getContext().close();
    }

    /**
     * 测试插入文章
     * 2017/05/09 测试通过 成功插入数据
     */
    @Test
    public void testInsert() {
        Article article = new Article();
        article.setArticleId("123");
        article.setTitle("第一篇文章");
        article.setContent("没有内容");
        User user = new User();
        user.setUserId("188");
        article.setUser(user);
        ArticleType articleType = new ArticleType();
        articleType.setArticleTypeId("111");
        article.setArticleType(articleType);
        articleMapper.insert(article);
    }
}
