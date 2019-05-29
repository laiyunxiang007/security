package com.yf.garden.bs.login.Filter;

import org.springframework.security.core.AuthenticationException;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String s) {
        super(s);
    }
}
