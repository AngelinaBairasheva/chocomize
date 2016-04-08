package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.domain.Users;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import mail.Mailing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * Отображение формы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderOrderPage(String user_login) {
        Users user = usersService.getUserByLogin(user_login);
        request.setAttribute("firstName", user.getName());
        request.setAttribute("lastName", user.getSecondName());
        request.setAttribute("middleName", user.getMiddleName());
        return Constants.ATTR_ORDER_PAGE;
    }

    /**
     * Обработка формы заказа
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String orderForm(String user_login, String country, String city,
                            String street, String house, String flat, String pay_type) {
        if (country == null || country.isEmpty() || city == null || city.isEmpty() || street == null || street.isEmpty() || house == null || house.isEmpty() ||
                flat == null || flat.isEmpty() || pay_type == null || pay_type.isEmpty()) {
            request.setAttribute("error", "Пожалуйста заполните все поля");
            return Constants.ATTR_ORDER_PAGE;
        }
        Mailing mail = new Mailing();
        /*mail.sendMail("chockomize.shop@gmail.com", user_login, "Chocomize Shop", "Welcome to Chocomize, dear "+firstName+"!\n" +
                "Help us secure your account in Chocomize by verifying your email address (" + email + ").\n" +
                "Paste the following link into your browser:\n" +
                "localhost:8080/registration/confirm/?user_login=" + email + "&key=" +(long)(r.nextDouble()*range) + "\n\n" +
                "You’re receiving this email because you recently created a new account in Chocomize. If this wasn’t you, please ignore this email.");
        System.out.println(mail.isStatus());*/
        return Constants.ATTR_ORDER_REZ_PAGE;
    }


}
