package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Order;
import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public void addOrder(Order order) {
        ordersRepository.addOrder(order);
    }
    @Transactional
    public void deleteOrder(Long order_id) {
        ordersRepository.deleteOrder(order_id);
    }
    @Transactional
    public List<Order> getUsersOrders(User user) {
        return ordersRepository.getUsersOrders(user);
    }
    @Transactional
    public List<Order> getAllOrders( ) {
        return ordersRepository.getAllOrders();
    }
}
