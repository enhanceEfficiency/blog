package cn.gsein.blog.front.controller;

import cn.gsein.blog.front.mapper.ArticleMapper;
import cn.gsein.blog.front.mapper.CommentMapper;
import cn.gsein.blog.front.mapper.MemorabiliaMapper;
import cn.gsein.blog.front.mapper.RequestRecordMapper;
import cn.gsein.blog.front.model.User;
import cn.gsein.blog.front.util.IpUtil;
import cn.gsein.blog.front.util.RequestInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/8/28.
 */
@Controller
public class PageController {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MemorabiliaMapper memorabiliaMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private RequestRecordMapper requestRecordMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("articles", articleMapper.findAll()); // 所有文章
        model.addAttribute("latestProgrammerArticle", articleMapper.findLatestArticleByCategoryId("9b743c67937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestGameDesignerArticle", articleMapper.findLatestArticleByCategoryId("a0df5321937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestInvestorArticle", articleMapper.findLatestArticleByCategoryId("acfbd690937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("latestTranslatorArticle", articleMapper.findLatestArticleByCategoryId("b10f49dd937811e7b36e9c5c8e6d8f44"));
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSome(6));
        model.addAttribute("visitTimes", requestRecordMapper.findRecordCount());
        return "/index";
    }

    @RequestMapping("/articleList/{categoryId}")
    public String articleList(@PathVariable String categoryId, Model model) {
        model.addAttribute("articleList", articleMapper.findByCategoryId(categoryId));
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSome(6));
        model.addAttribute("visitTimes", requestRecordMapper.findRecordCount());
        return "/articleList";
    }

    @RequestMapping("/article/{id}")
    public String article(@PathVariable String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            String ip = RequestInfoUtil.getRemoteHost(request);
            /*String city = IpUtil.getCityByIp(ip);*/
            model.addAttribute("username", "匿名网友"+ip);
        } else{
            model.addAttribute("username", user.getUsername());
        }
        model.addAttribute("article", articleMapper.findById(id)); // 所有文章
        model.addAttribute("memorabiliaList", memorabiliaMapper.findFirstSome(6));
        model.addAttribute("visitTimes", requestRecordMapper.findRecordCount());
        model.addAttribute("commentList", commentMapper.findByArticleId(id));
        return "/article";
    }
}
