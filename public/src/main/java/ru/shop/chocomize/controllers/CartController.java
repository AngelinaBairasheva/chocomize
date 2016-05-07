package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.Cart;
import com.springapp.mvc.api.domain.CartInfo;
import com.springapp.mvc.api.domain.Good;
import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.service.CartInfoService;
import com.springapp.mvc.api.service.CartsService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.security.AuthorizedUsersInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Контроллер для работы с корзиной
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
    @Autowired
    private UsersService usersService;

    @Autowired
    private CartsService cartsService;

    /**
     * Отображение содержимого корзины
     */
    @IncludeMenuInfo
    @RequestMapping
    public String renderCart() {
        User user = null;
        CartInfo cart = cartInfoService.getCartInfo(request.getSession());
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        if (user != null) {
            request.getSession().setAttribute("carts", cartsService.getUsersCarts(user));
            if (cart != null && cart.getGoods() != null) {
                addGoodsInUsersCartFromSession(user, cart);
            }
        }
        return Constants.ATTR_CART_PAGE;
    }

    /**
     * Добавление товара пользователем в корзину
     *
     * @param goodId id товара
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
        User user = null;
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        CartInfo cart1 = cartInfoService.getCartInfo(request.getSession());
        if (user != null) {
            if (cart1 != null && cart1.getGoods() != null) {
                addGoodsInUsersCartFromSession(user, cart1);
            }
            Long user_id = user.getId();
            if (usersService.userHasThisGoods(user.getId(), goodId)) {
                Cart cart = cartsService.getCartByUserAndGood(goodId, user_id);
                cart.setCount(cart.getCount() + 1);
                cartsService.updateCart(cart);
            } else {
                cartsService.addCart(new Cart(1,
                        goodsService.getGoodsById(goodId), usersService.getUserById(user_id)));
            }
            request.getSession().setAttribute("carts", cartsService.getUsersCarts(user));
        } else {
            cartInfoService.addInCart(request.getSession(), goodId, 1);
            updateSessionGoodsList();
        }
        return "ok";
    }

    /**
     * Изменение количесвта товара в корзине
     *
     * @param goodId id товара
     * @param count  количество товара
     */
    @RequestMapping(value = "/setCount", method = RequestMethod.POST)
    public String modifyCountOfGoodsInCart(Long goodId, Integer count) {
        User user = null;
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        if (user != null) {
            Cart cart = cartsService.getCartByUserAndGood(goodId, user.getId());
            cart.setCount(count);
            cartsService.updateCart(cart);
            request.getSession().setAttribute("carts", cartsService.getUsersCarts(user));
        } else {
            cartInfoService.addInCartBySelect(request.getSession(), goodId, count);
            updateSessionGoodsList();
        }
        return Constants.AJAX_CART_TOTAL;
    }

    /**
     * Удаление товара из корзины
     *
     * @param goodId id товара
     */
    @RequestMapping(value = "/deleteGood", method = RequestMethod.POST)
    public String deleteGoodInCart(Long goodId) {
        User user = null;
        if (AuthorizedUsersInfo.isLoggedIn()) {
            user = AuthorizedUsersInfo.getCurrentUser();
        }
        if (user != null) {
            Cart cart = cartsService.getCartByUserAndGood(goodId, user.getId());
            cartsService.deleteCart(cart);

            request.getSession().setAttribute("carts", cartsService.getUsersCarts(user));
        } else {
            cartInfoService.deleteGood(request.getSession(), goodId);
            updateSessionGoodsList();
        }
        return Constants.AJAX_CART_TOTAL;
    }

    private void addGoodsInUsersCartFromSession(User user, CartInfo cart) {
        for (Map.Entry<Long, Integer> entry : cart.getGoods().entrySet()) {
            if (usersService.userHasThisGoods(user.getId(), entry.getKey())) {
                Cart cart1 = cartsService.getCartByUserAndGood(entry.getKey(), user.getId());
                cart1.setCount(entry.getValue() + cartsService.getGoodsCount(entry.getKey(), user.getId()));
                cartsService.updateCart(cart1);
            } else {
                cartsService.addCart(new Cart(entry.getValue(), goodsService.getGoodsById(entry.getKey()), user));
            }
        }
        request.getSession().setAttribute(Constants.SESSION_CART, null);
    }

    private void updateSessionGoodsList() {
        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("cart");
        if (cartInfo != null) {
            List<Good> goodList = new LinkedList<>();
            for (Long id : cartInfo.getGoods().keySet()) {
                goodList.add(goodsService.getGoodsById(id));
            }
            request.getSession().setAttribute("goodsList", goodList);
        }
    }
}
