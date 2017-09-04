package cn.gsein.blog.back.service;

import cn.gsein.blog.front.model.Tag;

import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/4.
 */
public interface AdminTagService {
    int getTotalCount();

    int getTotalCountByTagName(String tagName);

    List<Tag> loadTags(Map<String, Object> params);

    void saveTag(Tag tag);

    Tag loadTag(String id);

    void updateTag(Tag tag);

    void deleteTag(String id);
}
