package ru.shop.chocomize.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;
import ru.shop.chocomize.form.RegistrationFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 *  онтроллер дл€ регистрации новых пользователей
 *
 */
@Controller
@RequestMapping("/reg")
public class RegistrationController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    /**
     * ќтображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    /**
     * ќбработка формы –егистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
//            RegistrationFormBean registrationFormBean, // TODO хот€ работает и без этой аннотации, обычно еЄ используют дл€ переименовани€ аргумента
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        // здесь должна происходить регистраци€ пользовател€
        System.out.println(registrationFormBean);
        return "registration/result";
    }
}
