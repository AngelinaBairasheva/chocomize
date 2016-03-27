package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainPageController extends BaseController  {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;

    @IncludeMenuInfo
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {

        request.setAttribute("newGoods",goodsService.getNewGoods());
        return Constants.ATTR_MAIN;
    }
}
