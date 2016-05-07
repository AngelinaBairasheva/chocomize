package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.domain.User;
import com.springapp.mvc.api.service.UsersService;
import com.springapp.mvc.api.util.Constants;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.RegistrationFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Контроллер для регистрации новых пользователей
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private HttpServletRequest request;
    /**
     * Отображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage(ModelMap modelMap) {
        modelMap.addAttribute(Constants.ATTR_REGISTRATION_FORM_BEAN, new RegistrationFormBean());
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
        if (bindingResult.hasErrors() || !password.equals(confirmPassword)||usersService.getUserByLogin(email)!=null) {
            if (!password.equals(confirmPassword)) {
                request.setAttribute("errorConfirming", "Пароли не совпадают");
            }
            if (usersService.getUserByLogin(email)!=null) {
                request.setAttribute("errorEmail", "Пользователь с таким E-mail уже зарегистрирован!");
            }
            return Constants.ATTR_REGISTRATION_PAGE;
        }
        User user = new User(hashPass, email, firstName, lastName, middleName, phone, false);

        user.setRole(Constants.ATTR_ROLE_USER);

        long range = 1234567L;
        user.setKey(user.getLogin().hashCode() * range);
        usersService.addUser(user);
        request.getSession().setAttribute("current_user", user);
        return "redirect:/mailing/registration";
    }

    /**
     * Подтверждение пользователей
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String renderPage(@RequestParam String user_login, @RequestParam Long key) {
        User user  = usersService.getUserByLogin(user_login);
        if(Objects.equals(key, user.getKey()))
        user.setEnabled(true);
        usersService.updateUser(user);
        return Constants.ATTR_LOGIN;
    }
}
