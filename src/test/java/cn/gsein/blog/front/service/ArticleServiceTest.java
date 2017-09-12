package cn.gsein.blog.front.service;

import cn.gsein.blog.front.model.ResultInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @Resource
    private ArticleService articleService;

    @Test
    public void saveComment() throws Exception {
        ResultInfo<Object> resultInfo = articleService.saveComment("10.100.13.213", "a4afa51f946d11e790f39c5c8e6d8f44", "武汉市匿名网友", "好顶赞！");
        System.out.println(resultInfo);

    }

}