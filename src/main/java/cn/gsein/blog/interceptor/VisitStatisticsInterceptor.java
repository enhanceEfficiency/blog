package cn.gsein.blog.interceptor;

import cn.gsein.blog.front.mapper.RequestRecordMapper;
import cn.gsein.blog.front.model.RequestRecord;
import cn.gsein.blog.front.util.DateUtil;
import cn.gsein.blog.front.util.RequestInfoUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by G.Seinfeld on 2017/9/11.
 */
@Component
public class VisitStatisticsInterceptor implements HandlerInterceptor {

    @Resource
    private RequestRecordMapper requestRecordMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestRecordMapper.save(RequestRecord.builder().ipAddress(RequestInfoUtil.getRemoteHost(request))
                .requestTime(DateUtil.getCurrentTimeStamp())
                .url(request.getRequestURL().toString())
                .build());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
