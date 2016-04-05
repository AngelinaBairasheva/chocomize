package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.service.CartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Контроллер для работы с корзиной
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartInfoService cartInfoService;

    /**
     * Отображение содержимого корзины
     */
    @RequestMapping
    public String renderCart() {
        return "cart/cartPage";
    }

    /**
     * Добавление товара неавторизованного пользователя в корзину
     *
     * @param goodId id товара
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(String goodId) {
        cartInfoService.addInCart(request.getSession(), goodId, 1);
        return "ok";
    }
}
