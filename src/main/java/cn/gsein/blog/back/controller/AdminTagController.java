package cn.gsein.blog.back.controller;

import cn.gsein.blog.back.service.AdminTagService;
import cn.gsein.blog.front.model.Pager;
import cn.gsein.blog.front.model.ResultInfo;
import cn.gsein.blog.front.model.Tag;
import cn.gsein.blog.front.util.ResultInfoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by G.Seinfeld on 2017/9/4.
 */
@Controller
@RequestMapping("/admin/tag")
public class AdminTagController {

    @Resource
    private AdminTagService adminTagService;

    private Logger log = LoggerFactory.getLogger(AdminTagController.class);

    @RequestMapping("/initPage")
    @ResponseBody
    public Pager<Tag> initPage(Integer page, String tagName) {
        Pager<Tag> pager = Pager.<Tag>builder().page(page).limit(10).build();
        pager.setStart((page - 1) * pager.getLimit());
        int totalCount = adminTagService.getTotalCountByTagName(tagName);
        pager.setTotalCount(totalCount);
        pager.setTotalPageNum((totalCount - 1) / pager.getLimit() + 1);
        return pager;

    }

    @RequestMapping("/load")
    public String load(Integer page, String tagName, Model model) {
        Pager<Tag> pager = Pager.<Tag>builder().page(page).limit(10).build();
        pager.setStart((page - 1) * pager.getLimit());
        Map<String, Object> params = new HashMap<>();
        params.put("pager", pager);
        params.put("tagName", tagName);
        List<Tag> tagList = adminTagService.loadTags(params);
        model.addAttribute("tagList", tagList);
        return "/admin/label/labelTable";
    }

    @RequestMapping("/addPage")
    public String toAddPage() {
        return "/admin/label/labelAdd";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ResultInfo<Object> save(String tagName) {
        try {
            tagName = URLDecoder.decode(tagName, "utf-8");
            Tag tag = Tag.builder().name(tagName).build();
            adminTagService.saveTag(tag);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("新增标签失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("新增标签成功！", null);
    }

    @RequestMapping("/editPage/{id}")
    public String toEditPage(@PathVariable String id, Model model) {
        Tag tag = adminTagService.loadTag(id);
        model.addAttribute("tag", tag);
        return "/admin/label/labelEdit";
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultInfo<Object> update(Tag tag) {
        try {
            String id = URLDecoder.decode(tag.getId(), "utf-8");
            Tag queriedTag = adminTagService.loadTag(id);
            queriedTag.setName(URLDecoder.decode(tag.getName(), "utf-8"));
            adminTagService.updateTag(queriedTag);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("修改标签失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("修改标签成功！", null);
    }


    @ResponseBody
    @RequestMapping("/delete/{id}")
    public ResultInfo<Object> delete(@PathVariable String id){
        try {
            adminTagService.deleteTag(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResultInfoFactory.getErrorResultInfo("删除标签失败！");
        }
        return ResultInfoFactory.getSuccessResultInfo("删除标签成功！", null);
    }
}
