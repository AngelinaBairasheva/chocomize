package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Address;
import com.springapp.mvc.api.domain.Cart;
import com.springapp.mvc.api.domain.Good;
import com.springapp.mvc.api.domain.User;
import org.hibernate.Criteria;
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
    public List<User> getAllUsers() {
        return curSession().createCriteria(User.class).list();
    }

    public User getUserById(Long id) {
        return (User) curSession().load(User.class, id);
    }

    public void addUser(User user) {
        curSession().save(user);
    }

    public void updateUser(User user) {
        curSession().update(user);
    }

    public void deleteUser(User user) {
        curSession().delete(user);
    }

    public User getUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }
    public boolean userHasThisGoods(Long users_id, Long goods_id) {
        Cart result;
        Good good;
        User user;
        Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit1.add(Restrictions.like("id", goods_id));
        good = (Good) crit1.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit2.add(Restrictions.like("id", users_id));
        user = (User) crit2.uniqueResult();
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        crit.add(Restrictions.like("good", good));
        crit.add(Restrictions.like("user", user));
        result = (Cart) crit.uniqueResult();
        return  result != null;
    }
    public boolean userHasThisAddress(Address address) {
        List<Address> result;
        Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Address.class);
        crit1.add(Restrictions.like("flat", address.getFlat()));
        crit1.add(Restrictions.like("house", address.getHouse()));
        crit1.add(Restrictions.like("area", address.getArea()));
        crit1.add(Restrictions.like("street", address.getStreet()));
        crit1.add(Restrictions.like("ad_index", address.getIndex()));
        crit1.add(Restrictions.like("user",address.getUser()));
        result =  crit1.list();
        return  result == null;
    }
}
