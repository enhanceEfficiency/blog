package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/8/29.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void save() {
        User user = User.builder().username("zei_kale").password("123456").avatarUrl("E:/abc.jpg").build();
        userMapper.save(user);
    }

    @Test
    public void findById() {
        User user = userMapper.findById("7a7b31e78c8611e782129c5c8e6d8f44");
        System.out.println(user);
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void update() {
        User user = userMapper.findById("7a7b31e78c8611e782129c5c8e6d8f44");
        user.setAvatarUrl("F:/def.png");
        int result = userMapper.update(user);
        System.out.println(result);
    }

    @Test
    public void delete(){
        User user = userMapper.findById("7a7b31e78c8611e782129c5c8e6d8f44");
        int result = userMapper.delete(user);
        System.out.println(result);
    }

    @Test
    public void deleteById(){
        int result = userMapper.deleteById("597d7f558c8711e782129c5c8e6d8f44");
        System.out.println(result);
    }

    @Test
    public void findTotalCount(){
        int count = userMapper.findTotalCount();
        System.out.println(count);
    }
}