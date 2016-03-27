package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.Goods;
import com.springapp.mvc.api.service.CategoriesService;
import com.springapp.mvc.api.service.GoodsService;
import com.springapp.mvc.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shop.chocomize.aspects.annotation.IncludeMenuInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Контроллер отвечающий за каталог
 */
@Controller
@RequestMapping(value = "/catalog")
public class CatalogController extends BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение каталога
     *
     * @param id    id категории
     * @param page  номер страницы
     * @param limit кол-во товаров отображаемых на странице
     * @return отображение каталога
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                Integer limit,
                                Model model) {
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.getGoodsByCategorysId(id), page == null ? 1 : page,
                limit == null ? Constants.ITEMS_LIMIT : limit);
        model.addAttribute("items", goods);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        model.addAttribute("brands",goodsService.getGoodsBrands());
        model.addAttribute("events",goodsService.getGoodsDatas());
        model.addAttribute("page", page);
        model.addAttribute("min", goodsService.getMinPrice());
        model.addAttribute("max", goodsService.getMaxPrice());
        model.addAttribute("currentPage", page);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goods, limit == null ? Constants.ITEMS_LIMIT : limit));
        model.addAttribute("limit", limit);
        return Constants.ATTR_CATALOG;
    }
}
