package com.yf.garden.bs.login.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/24i
 */
@Component
public class MyLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            String url = request.getParameter("url");//aa即为前端传来自定义跳转url地址
            response.sendRedirect(url);//实现自定义重定向
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
