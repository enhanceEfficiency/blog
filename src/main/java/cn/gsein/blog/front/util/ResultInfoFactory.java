package cn.gsein.blog.front.util;

import cn.gsein.blog.front.model.ResultInfo;

/**
 * Created by G.Seinfeld on 2017/9/4.
 */
public class ResultInfoFactory {

    public static <T> ResultInfo<T> getErrorResultInfo(String message) {
        return ResultInfo.<T>builder().code("fail").message(message).data(null).build();
    }

    public static <T> ResultInfo<T> getSuccessResultInfo(String message, T data) {
        return ResultInfo.<T>builder().code("success").message(message).data(data).build();
    }
}
