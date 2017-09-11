package cn.gsein.blog.front.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by G.Seinfeld on 2017/9/11.
 * 获取请求详细信息的工具类
 */
public class RequestInfoUtil {
    /**
     * 获取访问的ip地址
     * @param request 请求
     * @return ip地址
     */
    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
