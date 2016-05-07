package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Cart;
import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CartsService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.addCart(cart);
    }
    @Transactional
    public void updateCart(Cart cart) {
        cartRepository.updateCart(cart);
    }
    @Transactional
    public Integer getGoodsCount(Long good_id, Long user_id) {
        return cartRepository.getGoodsCount( good_id,  user_id);
    }
    @Transactional
    public List<Cart> getUsersCarts(User user) {
        return cartRepository.getUsersCarts(user);
    }

    @Transactional
    public Cart getCartById(Long id) {
        return cartRepository.getCartById(id);
    }
    @Transactional
    public Cart getCartByUserAndGood(Long good_id,Long user_id) {
        return cartRepository.getCartByUserAndGood( good_id, user_id);
    }
    @Transactional
    public void deleteCart(Cart cart){
        cartRepository.deleteCart(cart);
    }
}
