package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Memorabilia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * Created by G.Seinfeld on 2017/9/11.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemorabiliaMapperTest {

    @Resource
    private MemorabiliaMapper memorabiliaMapper;

    @Test
    public void save() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.FEBRUARY, 16);
        Memorabilia memorabilia = Memorabilia.builder().eventTime(calendar.getTime()).eventDescription("入职某不知名互联网企业").build();
        memorabiliaMapper.save(memorabilia);

        calendar.set(2016, Calendar.SEPTEMBER, 28);
        memorabilia = Memorabilia.builder().eventTime(calendar.getTime()).eventDescription("开始在某培训机构接受Java培训").build();
        memorabiliaMapper.save(memorabilia);

        calendar.set(2016, Calendar.AUGUST, 28);
        memorabilia = Memorabilia.builder().eventTime(calendar.getTime()).eventDescription("步入婚姻殿堂").build();
        memorabiliaMapper.save(memorabilia);

        calendar.set(2016, Calendar.JUNE, 15);
        memorabilia = Memorabilia.builder().eventTime(calendar.getTime()).eventDescription("从某国企离职，立志走上程序员之路").build();
        memorabiliaMapper.save(memorabilia);

        calendar.set(2014, Calendar.JULY, 2);
        memorabilia = Memorabilia.builder().eventTime(calendar.getTime()).eventDescription("获取某知名高校某理科专业硕士学位").build();
        memorabiliaMapper.save(memorabilia);
    }

    @Test
    public void findFirstSix() {
        List<Memorabilia> memorabilias = memorabiliaMapper.findFirstSix();
        for (Memorabilia memorabilia : memorabilias) {
            System.out.println(memorabilia);
        }
    }

    @Test
    public void findFirstSome() throws Exception {
        List<Memorabilia> memorabilias = memorabiliaMapper.findFirstSome(7);
        for (Memorabilia memorabilia : memorabilias) {
            System.out.println(memorabilia);
        }
    }

}