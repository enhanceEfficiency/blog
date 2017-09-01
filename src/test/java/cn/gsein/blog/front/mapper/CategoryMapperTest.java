package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/9/1.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryMapperTest {

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    public void save(){
        Category category = Category.builder().name("旅行").build();
        int result = categoryMapper.save(category);
        System.out.println(result);
    }

}