package cn.gsein.blog.front.mapper;

import cn.gsein.blog.front.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/1.
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    int findTotalCountByName(String tagName);

    List<Tag> findByParams(Map<String, Object> params);
}
