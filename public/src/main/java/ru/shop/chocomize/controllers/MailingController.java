package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.util.Constants;
import mail.Mailing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.security.AuthorizedUsersInfo;

import javax.servlet.http.HttpServletRequest;

/**
Контроллер для оповещения пользователей
 */
@Controller
@RequestMapping("/mailing")
public class MailingController {
    @Autowired
    private HttpServletRequest request;
    @IncludeMenuInfo
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String sendMailForChecking() {
        User user= (User) request.getSession().getAttribute("current_user");
        Mailing mailing=new Mailing();
        mailing.sendMail(user.getLogin(), "Добро пожаловать в Chocomize!\n" +
                "Вы (или кто-то, используя Ваше имя электронной почты) зарегистрировали логин "+ user.getLogin() +" для доступа в личный кабинет" +
                        "\n" +
                        "Если вы не делали такой запрос проигнорируйте это письмо.\n" +
                        "\n" +
                        "Чтобы подтвердить регистрацию <a href='localhost:8080/registration/confirm/?user_login=" + user.getLogin() + "&key=" + user.getKey() + "'>перейдите по ссылке</a>"+
                "\n\n" );
        System.out.println(mailing.isStatus());
        return Constants.ATTR_REG_REZULT;
    }
    @IncludeMenuInfo
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String sendMailForOrder() {
        User user= AuthorizedUsersInfo.getCurrentUser();
        System.out.println(user);
        Mailing mailing=new Mailing();
        mailing.sendMail(user.getLogin(), "Здравствуй, " + user.getName() + "!\n" +
                "Ваш заказ на сумму: " +  request.getSession().getAttribute("total_sum") + " успешно выполнен.\n");
                System.out.println(mailing.isStatus());
        return Constants.ATTR_ORDER_REZ_PAGE;
    }
    /*@IncludeMenuInfo
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String sendMailAboutLoginChanges() {
        Users user= AuthorizationInfo.getCurrentUser();
        System.out.println(user);
        Mailing mailing=new Mailing();
        mailing.sendMail(user.getLogin(), "Здравствуй, " + user.getName() + "!\n" +
                "Ваш новый E-mail: " +  request.getSession().getAttribute("total_sum") + " успешно выполнен.\n");
        System.out.println(mailing.isStatus());
        return Constants.ATTR_ORDER_REZ_PAGE;
    }*/
}
