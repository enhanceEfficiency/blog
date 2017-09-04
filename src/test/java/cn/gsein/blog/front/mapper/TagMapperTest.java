package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Pager;
import cn.gsein.blog.front.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by G.Seinfeld on 2017/9/4.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TagMapperTest {



    @Resource
    private TagMapper tagMapper;

    @Test
    public void findTotalCount() throws Exception {
        int count = tagMapper.findTotalCount();
        System.out.println(count);
    }

    @Test
    public void findTotalCountByName() throws Exception {
        int count = tagMapper.findTotalCountByName("旅行");
        System.out.println(count);
    }

    @Test
    public void findByParams() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("pager", Pager.<Tag>builder().start(0).limit(10).build());
        params.put("tagName", "默认");
        System.out.println(params);
        List<Tag> tags = tagMapper.findByParams(params);
        System.out.println(tags);
    }
}