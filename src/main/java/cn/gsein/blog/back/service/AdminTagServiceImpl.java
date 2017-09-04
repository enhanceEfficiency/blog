package cn.gsein.blog.back.service;

import cn.gsein.blog.front.mapper.TagMapper;
import cn.gsein.blog.front.model.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/4.
 */

@Service("adminTagService")
public class AdminTagServiceImpl implements AdminTagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public int getTotalCount() {
        return tagMapper.findTotalCount();
    }

    @Override
    public int getTotalCountByTagName(String tagName) {
        return tagMapper.findTotalCountByName(tagName);
    }

    @Override
    public List<Tag> loadTags(Map<String, Object> params) {
        return tagMapper.findByParams(params);
    }

    @Override
    public void saveTag(Tag tag) {
        tagMapper.save(tag);
    }

    @Override
    public Tag loadTag(String id) {
        return tagMapper.findById(id);
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.update(tag);
    }

    @Override
    public void deleteTag(String id) {
        tagMapper.deleteById(id);
    }
}
