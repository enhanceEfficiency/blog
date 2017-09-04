package cn.gsein.blog.front.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by G.Seinfeld on 2017/9/4.
 * ajax返回数据
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo<T> {
    private String code;
    private String message;
    private T data;
}
