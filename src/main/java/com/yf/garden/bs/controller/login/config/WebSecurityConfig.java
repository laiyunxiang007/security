package com.yf.garden.bs.controller.login.config;

import com.yf.garden.bs.controller.login.Filter.ValidateCodeFilter;
import com.yf.garden.bs.controller.login.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailHandler loginFailHandler;
    @Autowired
    private LoginOutSuccessHandler loginOutSuccessHandler;
    @Autowired
    private NoAuthorityHandler noAuthority;
    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;


    protected void cofigure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validationCodeFilter = new ValidateCodeFilter();
        /* 设置错误失败处理器 */
        validationCodeFilter.setMyAuthenticationFailHander(loginFailHandler);
        http
                .addFilterBefore(validationCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/api/bs/v1/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler)
                .and()
                .exceptionHandling().accessDeniedHandler(noAuthority)
                .and()
                .logout().logoutUrl("/api/bs/v1/logout")
                .addLogoutHandler(new MyLogoutHandler())
                .addLogoutHandler(loginOutSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/api/bs/v1/login", "/api/bs/v1/getcode")
//                .antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .csrf().disable();
    }
}
