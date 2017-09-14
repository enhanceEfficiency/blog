package cn.gsein.blog.front.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by G.Seinfeld on 2017/9/14.
 */
public class EncryptUtil {

    public static String md5(String src) {
        return new Md5PasswordEncoder().encodePassword(src, null);
    }


}
