package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/9/12.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentMapperTest {

    @Resource
    private CommentMapper commentMapper;

    @Test
    public void findCountByArticleId() throws Exception {
        int count = commentMapper.findCountByArticleId("a4afa51f946d11e790f39c5c8e6d8f44");
        System.out.println(count);
    }

    @Test
    public void findByArticleId() throws Exception {
        List<Comment> commentList = commentMapper.findByArticleId("a4afa51f946d11e790f39c5c8e6d8f44");
        System.out.println(commentList);
    }
}