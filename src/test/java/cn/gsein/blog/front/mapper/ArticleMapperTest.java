package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Article;
import cn.gsein.blog.front.model.Pager;
import cn.gsein.blog.front.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    public void save() {
        User user = userMapper.findById("7a7b31e78c8611e782129c5c8e6d8f44");
        Article article = Article.builder().author(user).views(160).title("这是一条神奇的天路")
                .content("这是一条神奇的天路，让中华儿女放在心上，一条条巨龙翻山越岭，给藏家儿女带来吉祥")
                .pictureUrl("images/asd.png")
                .build();
        int result = articleMapper.save(article);
        System.out.println(result);
    }

    @Test
    public void findById() {
        Article article = articleMapper.findById("38e720ea911a11e79e899c5c8e6d8f44");
        System.out.println(article);
    }

    @Test
    public void findAll() {
        List<Article> articles = articleMapper.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void update() {
        Article article = articleMapper.findById("18b54e378c9611e782129c5c8e6d8f44");
        article.setTitle("其实这并不是一条神奇的天路");
        int result = articleMapper.update(article);
        System.out.println(result);
    }

    @Test
    public void delete() {
        Article article = articleMapper.findById("18b54e378c9611e782129c5c8e6d8f44");
        int result = articleMapper.delete(article);
        System.out.println(result);
    }

    @Test
    public void deleteById() {
        int result = articleMapper.deleteById("c8dfe5488c9511e782129c5c8e6d8f44");
        System.out.println(result);
    }

    @Test
    public void findTotalCount() {
        int count = articleMapper.findTotalCount();
        System.out.println(count);
    }

    @Test
    public void findCountByParams() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("pager", Pager.builder().page(1).start(0).limit(10).build());
        params.put("categoryId", "1acc8cc58edf11e7af389c5c8e6d8f44");
        params.put("title", "这是");
        params.put("tagIds", null);
        int count = articleMapper.findCountByParams(params);
        System.out.println(count);
        /*if (tagIds != null && !"".equals(tagIds)) {
            params.put("tagIds", tagIds.split(","));
        } else {
            params.put("tagIds", null);
        }*/
    }

    @Test
    public void saveArticleTags() throws Exception {
        String articleId = "1";
        String[] tagIds = {"2", "3", "4"};
        Map<String, Object> params = new HashMap<>();
        params.put("articleId", articleId);
        params.put("tagIds", tagIds);
        int result = articleMapper.saveArticleTags(params);
        System.out.println(result);
    }

}