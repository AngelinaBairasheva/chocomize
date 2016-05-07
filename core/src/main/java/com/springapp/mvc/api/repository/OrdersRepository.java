package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Order;
import com.springapp.mvc.api.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }
    public void deleteOrder(Long order_id) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Order.class);
        crit.add(Restrictions.like("id",order_id));
        Order order= (Order) crit.uniqueResult();
        sessionFactory.getCurrentSession().delete(order);
    }
    public List<Order> getUsersOrders(User user) {
        List<Order> orders;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Order.class);
        crit.add(Restrictions.like("user", user));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        orders = crit.list();
        return orders;
    }
}
