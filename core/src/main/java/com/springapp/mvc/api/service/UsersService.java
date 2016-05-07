package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Address;
import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public void addUser(User user) {
        usersRepository.addUser(user);
    }
    @Transactional
    public User getUserById(Long id) {
        return usersRepository.getUserById(id);
    }
    @Transactional
    public User getUserByLogin(String login) {
        return usersRepository.getUserByLogin(login);
    }

    @Transactional
    public void updateUser(User user) {
        usersRepository.updateUser(user);
    }
    @Transactional
    public boolean userHasThisGoods(Long users_id, Long goods_id) {
        return usersRepository.userHasThisGoods(users_id, goods_id);
    }
    @Transactional
    public boolean userHasThisAddress( Address address) {
        return usersRepository.userHasThisAddress(address);
    }
}
