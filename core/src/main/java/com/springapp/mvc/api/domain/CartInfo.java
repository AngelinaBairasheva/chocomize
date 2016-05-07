package com.springapp.mvc.api.domain;

import java.util.Map;

/**
 * Содержимое корзины
 *
 */
public class CartInfo {
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
     * @param goodId id товара
     * @return кол-во товара в корзине
     */
    public Long getCount(Long goodId) {
        System.out.println("COUNT====");
        if (goods == null || goodId == null)
            return null;
        return Long.valueOf(goods.get(goodId));
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
