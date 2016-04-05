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

import java.util.Arrays;
import java.util.List;

/**
 * Контроллер отвечающий за каталог
 */
@Controller
@RequestMapping(value = "/catalog")
public class CatalogController extends BaseController {
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
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                Integer limit, String sorttype, String dir, Model model) {
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByCategorysId(id),
                sorttype == null ? "pstn" : sorttype, dir == null ? "asc" : dir), page, limit == null ? Constants.ITEMS_LIMIT : limit);
        model.addAttribute("items", goods);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        model.addAttribute("currentPage", page);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByCategorysId(id), limit == null ? Constants.ITEMS_LIMIT : limit));
        model.addAttribute("limit", limit == null ? Constants.ITEMS_LIMIT : limit);
        model.addAttribute("brandses", goodsService.getGoodsBrands());
        model.addAttribute("costs", goodsService.getMinPrice(id)+","+goodsService.getMaxPrice(id));
        System.out.println("COSTS="+goodsService.getMinPrice(id)+","+goodsService.getMaxPrice(id));
        model.addAttribute("brands", Arrays.toString(goodsService.getGoodsBrands().toArray()));
        model.addAttribute("min", goodsService.getMinPrice(id));
        model.addAttribute("max", goodsService.getMaxPrice(id));
        return Constants.ATTR_CATALOG;
    }

    /**
     * Показать еще товары на других страницах
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во отображаемых товаров
     * @param sorttype тип сортировки
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     */
    @RequestMapping(value = "/showMore", method = RequestMethod.POST)
    public String showMoreGoods(Long id, Integer page, Integer limit, String sorttype, String dir, String costs, String brands, Model model) {
         
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        System.out.println("page=" + page);
        model.addAttribute("items", goods);
        model.addAttribute("currentPage", page);
        model.addAttribute("dir", dir);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        model.addAttribute("brands", brands);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        return Constants.AJAX_GOODS;
    }

    /**
     * Установить размер количества отображаемых товаров на одной странице
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во отображаемых товаров
     * @param sorttype тип сортировки
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     */
    @RequestMapping(value = "/setLimit", method = RequestMethod.POST)
    public String setLimit(Long id, Integer page, Integer limit, String sorttype, String dir, String costs, String brands, Model model) {
       
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        model.addAttribute("items", goods);
        model.addAttribute("currentPage", page);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("dir", dir);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        model.addAttribute("brands", brands);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        return Constants.AJAX_GOODS;
    }

    /**
     * Сортировать товары по критерию
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во отображаемых товаров
     * @param sorttype тип сортировки
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     */
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String sortGoods(Long id, Integer page, Integer limit, String sorttype, String dir, String costs, String brands, Model model) {
         
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        model.addAttribute("items", goods);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("currentPage", page);
        model.addAttribute("sort", sorttype);
        model.addAttribute("dir", dir);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        model.addAttribute("brands", brands); 
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        return Constants.AJAX_GOODS;
    }

    /**
     * Отобрать товары по интервалу цены
     *
     * @param id       id категории
     * @param page     номер страницы
     * @param limit    кол-во отображаемых товаров
     * @param sorttype тип сортировки
     * @param dir      направление сортировки (по возрастанию/ по убыванию)
     */
    @RequestMapping(value = "/selectByPrice", method = RequestMethod.POST)
    public String selectByPrice(Long id, Integer page, Integer limit, String sorttype, String dir, String costs, String brands,
                                Model model) {
        System.out.println("SELECT BY PRICE");
        System.out.println("brans="+brands);
        System.out.println("ByPrice="+goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id)).size());
        System.out.println("ByBrands="+goodsService.getGoodsByBrands(brands,
                goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))).size());
        System.out.println("sort="+goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir).size());
        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(goodsService.getGoodsByBrands(brands,
                        goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        model.addAttribute("items", goods);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("currentPage", page);
        model.addAttribute("sort", sorttype);
        model.addAttribute("dir", dir);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        model.addAttribute("brands", brands);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        System.out.println("OK!!!");
        return Constants.AJAX_GOODS;
    }

    @RequestMapping(value = "/selectByBrands", method = RequestMethod.POST)
    public String selectByBrands(Long id, Integer page, Integer limit, String sorttype, String dir, String costs, String brands,
                                 Model model) {
        System.out.println("ERR");
        System.out.println("brands=" + brands);

        List<Goods> goods = goodsService.getGoodsByPage(goodsService.sortGoods(
                        goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), sorttype, dir),
                page, limit);
        model.addAttribute("items", goods);
        System.out.println("items" + goods);
        model.addAttribute("sorttype", sorttype);
        model.addAttribute("currentPage", page);
        model.addAttribute("sort", sorttype);
        model.addAttribute("dir", dir);
        model.addAttribute("pagesCount", goodsService.getPagesCount(goodsService.getGoodsByBrands(brands, goodsService.getGoodsByPrice(costs, goodsService.getGoodsByCategorysId(id))), limit));
        model.addAttribute("limit", limit);
        model.addAttribute("costs",costs);
        model.addAttribute("brands", brands);
        model.addAttribute("catalog", categoriesService.getCategoryById(id));
        return Constants.AJAX_GOODS;
    }
}
