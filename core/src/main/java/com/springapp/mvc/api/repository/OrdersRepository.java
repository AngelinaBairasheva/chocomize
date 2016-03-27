package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Goods;
import com.springapp.mvc.api.domain.Orders;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Goods> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Orders.class).list();
    }

    public void addOrder(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    public void updateOrder(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
    }
    public void deleteOrder(Orders orders) {
        sessionFactory.getCurrentSession().delete(orders);
    }
}
