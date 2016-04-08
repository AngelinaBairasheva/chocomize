package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Users;
import com.springapp.mvc.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public void addUser(Users users) {
        usersRepository.addUser(users);
    }
    @Transactional
    public Users getUserById(Long id) {
        return usersRepository.getUserById(id);
    }
    @Transactional
    public Users getUserByLogin(String login) {
        return usersRepository.getUserByLogin(login);
    }

    @Transactional
    public void updateUser(Users users) {
        usersRepository.updateUser(users);
    }
}
