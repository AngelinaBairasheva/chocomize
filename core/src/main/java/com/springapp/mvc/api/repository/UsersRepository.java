package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
    }

    public void addUser(Users users) {
        sessionFactory.getCurrentSession().save(users);
    }

    public void updateUser(Users users) {
        sessionFactory.getCurrentSession().update(users);
    }
    public void deleteUser(Users users) {
        sessionFactory.getCurrentSession().delete(users);
    }
}
