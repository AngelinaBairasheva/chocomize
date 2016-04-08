package com.springapp.mvc.api.domain;

import com.springapp.mvc.api.service.GoodsService;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Содержимое корзины
 *
 */
public class CartInfo {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private GoodsService goodsService;
    /**
     * key - id товара, value - кол-во товара
     */
    private Map<Long, Integer> goods;

    public Map<Long, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Integer> goods) {
        this.goods = goods;
    }

    /**
     * Получаем кол-во товара в корзине
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     * @return кол-во товара в корзине
     */
    public Long getCount(Long goodId) {
        if (goods == null || goodId == null)
            return null;
        return Long.valueOf(goods.get(goodId));
    }
    public Goods getGoodById(Long goodId){
        System.out.println("GETLOOONG");
        Goods result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit.add(Restrictions.like("id", goodId));
        result = (Goods) crit.uniqueResult();
        System.out.println("REZULT="+result);
        return result;
        //return   goodsService.getGoodsById(goodId);
    }
    /**
     * Есть ли в корзине товар с этим id
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     */
    public boolean containsGoodId(Long goodId) {
        if (goods == null || goodId == null)
            return false;
        return goods.containsKey(goodId);
    }
}
