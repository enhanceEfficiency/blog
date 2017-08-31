package cn.gsein.blog.security;

import cn.gsein.blog.front.model.User;
import cn.gsein.blog.front.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by G.Seinfeld on 2017/8/30.
 */
@Configuration
@EnableWebSecurity
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
       /* System.out.println("username: " + token.getName());
        System.out.println("password: " + token.getCredentials());*/
        String username = token.getName();
        User user = null;
        if (username != null) {
            user = userService.findByUsername(username);
        }

        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码无效");
        }
        String password = user.getPassword();
        if (!password.equals(new Md5PasswordEncoder().encodePassword(token.getCredentials().toString(), null))) {
            throw new BadCredentialsException("用户名或密码无效");
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass); // 支持UsernamePasswordAuthenticationToken及其子类
    }
}
