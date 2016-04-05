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
    private Map<String, Integer> goods;

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, Integer> goods) {
        this.goods = goods;
    }

    /**
     * Получаем кол-во товара в корзине
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     * @return кол-во товара в корзине
     */
    public Integer getCount(String goodId) {
        if (goods == null || goodId == null)
            return null;
        return goods.get(goodId);
    }

    /**
     * Есть ли в корзине товар с этим id
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     */
    public boolean containsGoodId(String goodId){
        if (goods == null || goodId == null)
            return false;
        return goods.containsKey(goodId);
    }
}
