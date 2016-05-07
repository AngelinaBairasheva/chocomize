package ru.shop.chocomize.security;

import com.springapp.mvc.api.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    /**
     * ������ � ������������ �� ��
     */
    private User userInfo;

    public MyUserDetail(User userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return ��������� ���� ������� ������������
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash ������ ������������
     */
    @Override
    public String getPassword() {
        return userInfo.getHash_password();
    }

    /**
     * ����� (���) ������������
     */
    @Override
    public String getUsername() {
        return userInfo.getLogin();
    }

    /**
     * @return ����, ��� ���� �������� �������� ��� �� �����, �� �������
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return ����, ��� ������������ �� ������������ ���������������� �����
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return ����, ��� ���� �������� ������ ��� �� �����, �� �������
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return ����, ��� ������������ ������� � �����������
     */
    @Override
    public boolean isEnabled() {
        return userInfo.getEnabled();
    }
    public User getUsers() {
        System.out.println("getUsers");
        return userInfo;
    }

    public void setUsers(User userInfo) {
        this.userInfo = userInfo;
    }
}
