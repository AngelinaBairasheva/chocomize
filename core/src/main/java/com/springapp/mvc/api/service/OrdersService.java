package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Orders;
import com.springapp.mvc.api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public void addOrder(Orders orders) {
        ordersRepository.addOrder(orders);
    }
    @Transactional
     public void deleteOrder(Orders orders) {
        ordersRepository.deleteOrder(orders);
    }
}
