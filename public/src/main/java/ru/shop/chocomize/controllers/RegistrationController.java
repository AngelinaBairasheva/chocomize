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
 * ���������� ��� ����������� ����� �������������
 *
 */
@Controller
@RequestMapping("/reg")
public class RegistrationController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    /**
     * ����������� �������� �����������
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    /**
     * ��������� ����� �����������
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
//            RegistrationFormBean registrationFormBean, // TODO ���� �������� � ��� ���� ���������, ������ � ���������� ��� �������������� ���������
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        // ����� ������ ����������� ����������� ������������
        System.out.println(registrationFormBean);
        return "registration/result";
    }
}
