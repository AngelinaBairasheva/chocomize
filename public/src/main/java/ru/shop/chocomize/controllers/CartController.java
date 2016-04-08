package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.CartInfo;
import com.springapp.mvc.api.domain.Goods;
import com.springapp.mvc.api.service.CartInfoService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

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
    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение содержимого корзины
     */
    @IncludeMenuInfo
    @RequestMapping
    public String renderCart() {
        CartInfo cartInfo= (CartInfo) request.getSession().getAttribute("cart");
        if(cartInfo!=null) {
            List<Goods> goodsList = new LinkedList<>();
            for (Long id : cartInfo.getGoods().keySet()) {
                goodsList.add(goodsService.getGoodsById(id));
            }
            request.setAttribute("items", goodsList);
        }
        return Constants.ATTR_CART_PAGE;
    }

    /**
     * Добавление товара неавторизованного пользователя в корзину
     *
     * @param goodId id товара
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
        cartInfoService.addInCart(request.getSession(), goodId, 1);
        return "ok";
    }

    @RequestMapping(value = "/setCount", method = RequestMethod.POST)
    public String modifyCountOfGoodsInCart(Long goodId, Integer count) {
        System.out.println("GOODID="+goodId);
        cartInfoService.addInCartBySelect(request.getSession(), goodId, count);
        CartInfo cartInfo= (CartInfo) request.getSession().getAttribute("cart");
        if(cartInfo!=null) {
            List<Goods> goodsList = new LinkedList<>();
            for (Long id : cartInfo.getGoods().keySet()) {
                goodsList.add(goodsService.getGoodsById(id));
            }
            System.out.println("GOODSLIST=" + goodsList);
            request.setAttribute("items", goodsList);
        }
        return Constants.AJAX_CART_TOTAL;
    }
    @RequestMapping(value = "/deleteGood", method = RequestMethod.POST)
    public String deleteGoodInCart(Long goodId) {
        System.out.println("GOODID="+goodId);
        cartInfoService.deleteGood(request.getSession(),goodId);
        CartInfo cartInfo= (CartInfo) request.getSession().getAttribute("cart");
        if(cartInfo!=null) {
            List<Goods> goodsList = new LinkedList<>();
            for (Long id : cartInfo.getGoods().keySet()) {
                goodsList.add(goodsService.getGoodsById(id));
            }
            System.out.println("GOODSLIST=" + goodsList);
            request.setAttribute("items", goodsList);
        }
        return Constants.AJAX_CART_TOTAL;
    }
}
