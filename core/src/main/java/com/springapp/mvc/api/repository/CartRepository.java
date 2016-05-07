package com.springapp.mvc.api.repository;


import com.springapp.mvc.api.domain.Cart;
import com.springapp.mvc.api.domain.Good;
import com.springapp.mvc.api.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Cart> getAllCarts() {
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
    }

    public void addCart(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }

    public void updateCart(Cart cart) {
        sessionFactory.getCurrentSession().update(cart);
    }

    public Integer getGoodsCount(Long good_id, Long user_id) {
        Cart cart;
        Good good;
        User user;
        Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit1.add(Restrictions.like("id", good_id));
        good = (Good) crit1.uniqueResult();
        good = (Good) crit1.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit2.add(Restrictions.like("id", user_id));
        user = (User) crit2.uniqueResult();
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        crit.add(Restrictions.like("good", good));
        crit.add(Restrictions.like("user", user));
        cart = (Cart) crit.uniqueResult();
        return cart.getCount();
    }

    public List<Cart> getUsersCarts(User user) {
        List<Cart> carts;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        crit.add(Restrictions.like("user", user));
        carts = crit.list();
        return carts;
    }
    public Cart getCartById(Long id) {
        return (Cart) sessionFactory.getCurrentSession().load(Cart.class, id);
    }
    public Cart getCartByUserAndGood(Long good_id,Long user_id) {
        Good good;
        User user;
        Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit1.add(Restrictions.like("id", good_id));
        good = (Good) crit1.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit2.add(Restrictions.like("id", user_id));
        user = (User) crit2.uniqueResult();
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        crit.add(Restrictions.like("good", good));
        crit.add(Restrictions.like("user", user));
        return  (Cart) crit.uniqueResult();
    }
    public void deleteCart(Cart cart) {
        sessionFactory.getCurrentSession().delete(cart);
    }
}
