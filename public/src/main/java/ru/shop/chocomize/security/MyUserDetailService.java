package ru.shop.chocomize.security;

import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UsersService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User userInfo = userService.getUserByLogin(login);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new MyUserDetail(userInfo);
    }

}
