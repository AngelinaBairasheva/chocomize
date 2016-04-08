package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.CartInfo;
import com.springapp.mvc.api.util.Constants;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Service
public class CartInfoService {

    /**
     * Добавление товара в корзину
     */
    public void addInCart(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(goodId, count);
            cart.setGoods(map);
        } else {
            if (cart.containsGoodId(goodId)) {
                System.out.println("CONTAINS GOOD Kol="+cart.getGoods().get(goodId) + count);
                cart.getGoods().put(goodId, cart.getGoods().get(goodId) + count);
            } else {
                cart.getGoods().put(goodId, count);
            }
        }
        System.out.println("CART_SIZE="+cart.getGoods().size());
        session.setAttribute(Constants.SESSION_CART, cart);
    }
    public void deleteGood(HttpSession session, Long goodId) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        System.out.println("CARTSIZE="+cart.getGoods().size());
        cart.getGoods().remove(goodId);
        System.out.println("CARTSIZE="+cart.getGoods().size());
        session.setAttribute(Constants.SESSION_CART, cart);
    }
    public void addInCartBySelect(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(goodId, count);
            cart.setGoods(map);
        } else {
            if (cart.containsGoodId(goodId)) {
                cart.getGoods().put(goodId, count);
            } else {
                cart.getGoods().put(goodId, count);
            }
        }
        System.out.println("CART_SIZE=" + cart.getGoods().size());
        session.setAttribute(Constants.SESSION_CART, cart);
    }

}
