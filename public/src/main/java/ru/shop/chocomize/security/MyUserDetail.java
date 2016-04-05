package ru.shop.chocomize.security;

import com.springapp.mvc.api.domain.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 */
public class MyUserDetail implements UserDetails {

    /**
     * запись о пользователе из БД
     */
    private Users userInfo;

    public MyUserDetail(Users userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return коллекция прав доступа пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash пароля пользователя
     */
    @Override
    public String getPassword() {
        return userInfo.getHash_passport();
    }

    /**
     * Логин (имя) пользователя
     */
    @Override
    public String getUsername() {
        return userInfo.getLogin();
    }

    /**
     * @return флаг, что срок действия аккаунта еще не истек, он активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь не заблокирован администраторами сайта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return флаг, что срок действия пароля еще не истек, он активен
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь включен и подтвержден
     */
    @Override
    public boolean isEnabled() {
        return userInfo.getEnabled();
    }

    public Users getUsers() {
        return userInfo;
    }

    public void setUsers(Users userInfo) {
        this.userInfo = userInfo;
    }
}
