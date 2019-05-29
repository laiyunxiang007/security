package com.yf.garden.bs.login.config;

import com.yf.garden.common.util.StringUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(StringUtil.encryptMD5((String) rawPassword));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return StringUtil.encryptMD5((String) rawPassword);
    }
}