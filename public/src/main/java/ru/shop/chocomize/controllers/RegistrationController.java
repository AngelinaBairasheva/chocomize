package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.domain.Users;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import mail.Mailing;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.RegistrationFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Random;

/**
 * Контроллер для регистрации новых пользователей
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsersService usersService;

    /**
     * Отображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(Constants.ATTR_REGISTRATION_FORM_BEAN, new RegistrationFormBean());
        return Constants.ATTR_REGISTRATION_PAGE;
    }

    /**
     * Обработка формы Регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(Constants.ATTR_REGISTRATION_FORM_BEAN) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult) {
        String firstName = registrationFormBean.getFirstName();
        String lastName = registrationFormBean.getLastName();
        String middleName = registrationFormBean.getMiddleName();
        String email = registrationFormBean.getEmail();
        String phone = registrationFormBean.getPhone();
        String password = registrationFormBean.getPassword();
        String confirmPassword = registrationFormBean.getConfirmPassword();
        String hashPass = DigestUtils.md5Hex(password);
        System.out.println(firstName + ", " + lastName + ", " + middleName + ", " + email + ", " + phone + ", " + password);
        if (bindingResult.hasErrors() || !password.equals(confirmPassword)||usersService.getUserByLogin(email)!=null) {
            if (!password.equals(confirmPassword)) {
                request.setAttribute("errorConfirming", "Пароли не совпадают");
            }
            if (usersService.getUserByLogin(email)!=null) {
                request.setAttribute("errorEmail", "Пользователь с таким E-mail уже зарегистрирован!");
            }
            return Constants.ATTR_REGISTRATION_PAGE;
        }
        Users user = new Users(hashPass, email, firstName, lastName, middleName, phone, false);
        user.setRole("ROLE_USER");
        usersService.addUser(user);
        Mailing mail = new Mailing();
        long range = 1234567L;
        Random r = new Random();
        mail.sendMail("chockomize.shop@gmail.com", email, "Chocomize Shop", "Welcome to Chocomize, dear "+firstName+"!\n" +
                "Help us secure your account in Chocomize by verifying your email address (" + email + ").\n" +
                "Paste the following link into your browser:\n" +
                "localhost:8080/registration/confirm/?user_login=" + email + "&key=" +(long)(r.nextDouble()*range) + "\n\n" +
                "You’re receiving this email because you recently created a new account in Chocomize. If this wasn’t you, please ignore this email.");
        System.out.println(mail.isStatus());
        // здесь должна происходить регистрация пользователя
        System.out.println(registrationFormBean);
        return Constants.ATTR_REG_REZULT;
    }

    /**
     * Подтверждение пользователей
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String renderPage(@RequestParam String user_login, @RequestParam Long key) {
        Users users = usersService.getUserByLogin(user_login);
        System.out.println(users);
        users.setKey(key);
        users.setEnabled(true);
        usersService.updateUser(users);
        System.out.println("enabled="+usersService.getUserByLogin(user_login).getEnabled());
        System.out.println(users);
        return Constants.ATTR_LOGIN;
    }
}
