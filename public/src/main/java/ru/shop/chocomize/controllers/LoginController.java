package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @IncludeMenuInfo
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Boolean error) {
        request.setAttribute("error", error);
        return Constants.ATTR_LOGIN;
    }
}
