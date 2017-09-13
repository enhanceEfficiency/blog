package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Memorabilia;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/9/11.
 */
@Mapper
public interface MemorabiliaMapper extends BaseMapper<Memorabilia>{
    /**
     * 查找前六条大事记数据（按时间倒序，正好在页面上显示）
     * @return 前六条大事记的集合
     */
    List<Memorabilia> findFirstSix();

    /**
     * 查找前若干条大事记数据（按时间倒序）
     * @param num 指定的条数
     * @return 指定条数大事记的集合
     */
    List<Memorabilia> findFirstSome(int num);
}
