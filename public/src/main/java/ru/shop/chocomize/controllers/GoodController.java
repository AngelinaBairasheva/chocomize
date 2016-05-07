package ru.shop.chocomize.controllers;


import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Контроллер для работы с карточкой товара
 *
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderItemsPage(@PathVariable Long id,
                                  @RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "limit", required = false)Integer limit,
                                  @RequestParam(value = "sorttype", required = false)String sorttype,
                                  @RequestParam(value = "dir", required = false)String dir, String brands,
                                  String costs) {
        request.setAttribute("item", goodsService.getGoodsById(id));
        request.setAttribute("page", page);
        request.setAttribute("limit", limit);
        request.setAttribute("sorttype", sorttype);
        request.setAttribute("dir", dir);
        System.out.println("goodsService.getGoodsByCategorysId(id)="+goodsService.getGoodsByCategorysId(id));
        request.setAttribute("brands", brands);
        request.setAttribute("costs", costs);
        return Constants.ATTR_ITEM;
    }

}
