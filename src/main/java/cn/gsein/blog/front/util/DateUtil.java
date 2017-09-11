package cn.gsein.blog.front.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by G.Seinfeld on 2017/9/11.
 * 日期工具类
 */
public class DateUtil {
    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date getCurrentTime(){
        return new Date();
    }

    /**
     * 获取当前时间戳
     * @return 当前时间戳
     */
    public static Timestamp getCurrentTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
