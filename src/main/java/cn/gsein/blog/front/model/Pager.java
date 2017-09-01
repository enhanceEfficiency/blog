package cn.gsein.blog.front.model;

import lombok.*;

import java.util.List;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pager<T> {
    private int totalCount; //总条数
    private int totalPageNum; //总页数
    private List<T> rows;  //本页的数据
    private int page; //第几页
    private int start; //每页开始的下标
    private int limit; //每页多少条
    private int end; //每页结束的下标
}
