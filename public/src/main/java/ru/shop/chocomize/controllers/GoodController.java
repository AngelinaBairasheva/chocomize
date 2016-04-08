package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.service.CategoriesService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;
/**
 * Контроллер для работы с карточкой товара
 *
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController extends BaseController{
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private GoodsService goodsService;
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderItemsPage(@PathVariable Long id) {

        request.setAttribute("item", goodsService.getGoodsById(id));
        request.setAttribute("page", request.getParameter("page"));
        request.setAttribute("limit", request.getParameter("limit"));
        request.setAttribute("sorttype", request.getParameter("sorttype"));
        request.setAttribute("dir", request.getParameter("dir"));
        request.setAttribute("brands", request.getParameter("brands"));
        request.setAttribute("costs", request.getParameter("costs"));
        return Constants.ATTR_ITEM;
    }

}
