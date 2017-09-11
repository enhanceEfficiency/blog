package cn.gsein.blog.configuration;

import cn.gsein.blog.interceptor.VisitStatisticsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by G.Seinfeld on 2017/9/11.
 */
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Resource
    private VisitStatisticsInterceptor visitStatisticsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(visitStatisticsInterceptor).addPathPatterns("/**");
    }
}
