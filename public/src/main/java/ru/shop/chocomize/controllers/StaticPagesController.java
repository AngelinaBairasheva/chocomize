package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;


@Controller
public class StaticPagesController {
    @Autowired
    private HttpServletRequest request;
    /**
     * Отображение страницы регистрации
     */
    @IncludeMenuInfo
    @RequestMapping(method = RequestMethod.GET, value = "/about")
    public String renderAboutPage() {
        return Constants.ATTR_ABOUT_PAGE;
    }


}
