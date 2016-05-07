package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.domain.*;
import com.springapp.mvc.api.service.AddressService;
import com.springapp.mvc.api.service.CartsService;
import com.springapp.mvc.api.service.OrdersService;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.OrderFormBean;
import ru.shop.chocomize.security.AuthorizedUsersInfo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Контроллер для оформления заказов пользователей
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsersService usersService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartsService cartsService;

    /**
     * Отображение формы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderOrderPage(ModelMap modelMap) {
        BigDecimal total_sum = new BigDecimal(request.getParameter("total_sum").replace(",", "."));
        BigDecimal total_count = new BigDecimal(request.getParameter("total_count").replace(",", "."));
        User user = AuthorizedUsersInfo.getCurrentUser();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("total_count", total_count);
        modelMap.addAttribute("total_sum", total_sum);
        modelMap.addAttribute(Constants.ATTR_ORDER_FORM_BEAN, new OrderFormBean());
        return Constants.ATTR_ORDER_PAGE;
    }

    /**
     * Обработка формы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String addOrder(
            @Valid @ModelAttribute(Constants.ATTR_ORDER_FORM_BEAN) OrderFormBean addressFormBean,
            BindingResult bindingResult) {
        String payment_type = addressFormBean.getPay_type();
        User user = AuthorizedUsersInfo.getCurrentUser();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            request.setAttribute("total_count", request.getParameter("total_count"));
            request.setAttribute("total_sum", request.getParameter("total_sum"));
            request.setAttribute("user", user);
            return Constants.ATTR_ORDER_PAGE;
        }
        BigDecimal total_sum = new BigDecimal(request.getParameter("total_sum").replace(",", "."));
        BigDecimal total_count = new BigDecimal(request.getParameter("total_count").replace(",", "."));
        Address address = new Address(Integer.valueOf(addressFormBean.getIndex()),
                Integer.valueOf(addressFormBean.getHouse()), Integer.valueOf(addressFormBean.getFlat()),
                addressFormBean.getCity(), addressFormBean.getStreet(),
                addressFormBean.getArea(), user);
        if (!usersService.userHasThisAddress(address)) {
            addressService.addAddress(address);
        }
        Order order = new Order(Calendar.getInstance(), total_sum, total_count, "В обработке", payment_type, user, address);
        List<Cart> carts = cartsService.getUsersCarts(user);
        List<Good> goodList = new ArrayList<>();
        for (Cart cart : carts) {
            goodList.add(cart.getGood());
        }
        order.setGoods(goodList);
        ordersService.addOrder(order);
        for (Cart cart : carts) {
            cartsService.deleteCart(cart);
        }
        request.getSession().setAttribute("carts",null);
        request.getSession().setAttribute("total_sum", total_sum);
        return "redirect:/mailing/order";
    }

    @IncludeMenuInfo
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public String deleteOrder(Long orderId) {
        ordersService.deleteOrder(orderId);
        User user = AuthorizedUsersInfo.getCurrentUser();
        List<Order> orders = ordersService.getUsersOrders(user);
        request.setAttribute("orders", orders);
        return Constants.ATTR_CABINET_ORDERS;
    }
}
