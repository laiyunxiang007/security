package com.yf.garden.bs.login.Filter;

import com.yf.garden.bs.controller.LoginController;
import com.yf.garden.bs.login.handler.LoginFailHandler;
import com.yf.garden.bs.login.model.VerifyCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    private LoginFailHandler loginFailHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader("token");
        if (header == null || httpServletRequest.getRequestURI().equals("/api/bs/v1/page")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (httpServletRequest.getRequestURI().equals("/api/bs/v1/login")
                && httpServletRequest.getMethod().equalsIgnoreCase("post")) {
            try {
                validate(new ServletWebRequest(httpServletRequest));
            } catch (ValidateCodeException e) {
                loginFailHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                // 不继续执行
                return;
            }
        }
        // 继续执行下一步
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    //校验逻辑
    private void validate(ServletWebRequest request) throws ServletRequestBindingException, ValidateCodeException {

        // 从Session中获取imageCode对象
        VerifyCode verifyCode = (VerifyCode) sessionStrategy.getAttribute(request, LoginController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        System.out.println("从session获取在imagecode对象" + verifyCode + "    " + codeInRequest);
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码为空或者不存在");
        }
        if (verifyCode == null) {
            throw new ValidateCodeException("验证码不存在，请刷新验证码");
        }
        if (verifyCode.isExpired()) {
            //从session移除过期的验证码
            sessionStrategy.removeAttribute(request, LoginController.SESSION_KEY);
            throw new ValidateCodeException("验证码过期");
        }
        if (!StringUtils.equalsIgnoreCase(verifyCode.getText(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        // session 中移除key
        sessionStrategy.removeAttribute(request, LoginController.SESSION_KEY);
    }

    public LoginFailHandler getMyAuthenticationFailHander() {
        return loginFailHandler;
    }

    public void setMyAuthenticationFailHander(LoginFailHandler myAuthenticationFailHander) {
        this.loginFailHandler = myAuthenticationFailHander;
    }

}
