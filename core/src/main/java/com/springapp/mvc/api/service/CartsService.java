package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Cart;
import com.springapp.mvc.api.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartsService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.addCart(cart);
    }

}
