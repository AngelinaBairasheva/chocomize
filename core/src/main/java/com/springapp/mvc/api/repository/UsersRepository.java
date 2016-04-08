package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @Autowired
    private SessionFactory sessionFactory;


    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        return curSession().createCriteria(Users.class).list();
    }

    public Users getUserById(Long id) {
        return (Users) curSession().load(Users.class, id);
    }

    public void addUser(Users users) {
        curSession().save(users);
    }

    public void updateUser(Users users) {
        curSession().update(users);
    }

    public void deleteUser(Users users) {
        curSession().delete(users);
    }

    public Users getUserByLogin(String login) {
        return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }
}
