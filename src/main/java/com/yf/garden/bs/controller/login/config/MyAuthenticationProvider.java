package com.yf.garden.bs.controller.login.config;

import com.yf.garden.bs.controller.login.model.UserDetailService;
import com.yf.garden.bs.controller.login.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailService userDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserInfo userInfo = (UserInfo) userDetailService.loadUserByUsername(username);
        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");

        }
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();

        if (!myPasswordEncoder.matches(password, userInfo.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
