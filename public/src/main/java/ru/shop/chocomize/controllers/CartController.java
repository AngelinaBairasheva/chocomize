package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ���������� ��� ������ � ��������
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartsService cartService;

    /**
     * ����������� ����������� �������
     */
    @RequestMapping
    public String renderCart() {
        return "cart/cartPage";
    }

    /**
     * ���������� ������ � �������
     *
     * @param goodId id ������
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
       // cartService.addCart(request.getSession(), goodId, 1);
        return "ok";
    }
}
