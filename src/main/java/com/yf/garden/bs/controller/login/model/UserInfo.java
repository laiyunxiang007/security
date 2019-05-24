package com.yf.garden.bs.controller.login.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
@Data
public class UserInfo implements Serializable, UserDetails {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String role;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserInfo(String username, String password, String role, boolean accountNonExpired, boolean accountNonLocked,
                    boolean credentialsNonExpired, boolean enabled) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    // 这是权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {

        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return enabled;
    }

}
