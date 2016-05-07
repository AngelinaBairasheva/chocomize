package ru.shop.chocomize.controllers;

import com.springapp.mvc.api.domain.Good;
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

import java.util.Arrays;
import java.util.List;

/**
 * Контроллер отвечающий за каталог
 */
@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private GoodsService goodsService;

    /**
     * Отображение каталога
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во товаров, отображаемых на странице
     * @param sorttype тип сортировки
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     * @return отображение каталога
     */
    @IncludeMenuInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                Model model,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", required = false, defaultValue = "6")Integer limit,
                                @RequestParam(value = "sorttype", required = false, defaultValue = "pstn")String sorttype,
                                @RequestParam(value = "dir", required = false, defaultValue = "asc")String dir, String brands,
                                String costs) {
        costs=costs==null?goodsService.getMinPrice(goodsService.getGoodsByCategorysId(id))+","
                +goodsService.getMaxPrice(goodsService.getGoodsByCategorysId(id)):costs;
        List<Good> goods= goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs,
                                goodsService.getGoodsByCategorysId(id))), sorttype, dir), page, limit);
        model.addAttribute("items", goods);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        model.addAttribute("currentPage", page);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("dir", dir);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByCategorysId(id), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("brandses", goodsService.getGoodsBrands());
        model.addAttribute("costs", costs);
        model.addAttribute("brands", brands==null?Arrays.toString(goodsService.getGoodsBrands().toArray()):brands);
        model.addAttribute("min", goodsService.getMinPrice(goodsService.getGoodsByCategorysId(id)));
        model.addAttribute("max", goodsService.getMaxPrice(goodsService.getGoodsByCategorysId(id)));
        return Constants.ATTR_CATALOG;
    }

    /**
     * Фильтрация или сортировка товаров
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во отображаемых товаров
     * @param sorttype тип сортировки
     * @param costs интервал цены
     * @param brands брэнды товаров
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     */
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String showMoreGoods( Long id,
                                Model model,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", required = false, defaultValue = "6")Integer limit,
                                @RequestParam(value = "sorttype", required = false, defaultValue = "pstn")String sorttype,
                                @RequestParam(value = "dir", required = false, defaultValue = "asc")String dir, String brands,
                                @RequestParam(value = "costs", required = false)String costs) {
        costs=costs==null?goodsService.getMinPrice(goodsService.getGoodsByCategorysId(id))+","+goodsService.getMaxPrice(
                goodsService.getGoodsByCategorysId(id)):costs;
        List<Good> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        if(goods!=null&&goods.isEmpty()){
            int i=page;
            while (--i>0){
                goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                                goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                        i, limit);
                if(!goods.isEmpty()){
                    page=i;
                    break;
                }
            }
        }
        model.addAttribute("items", goods);
        model.addAttribute("currentPage", page);
        model.addAttribute("dir", dir);
        model.addAttribute("sorttype",  sorttype);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands,
                goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        if(brands == null){
           brands= Arrays.toString(goodsService.getGoodsBrands().toArray());
        }else {
            if(brands.charAt(0)=='\"'){
                brands=brands.substring(1,brands.length()-1);
            }
        }
        model.addAttribute("brands", brands);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        return Constants.AJAX_GOODS;
    }
}
