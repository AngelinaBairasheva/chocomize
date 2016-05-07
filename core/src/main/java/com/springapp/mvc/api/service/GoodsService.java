package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Good;
import com.springapp.mvc.api.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional
    public void addGood(Good good) {
        goodsRepository.addGood(good);
    }

    @Transactional
    public List<Good> getGoodsByBrands(String brand,List<Good> goodses) {
        return goodsRepository.getGoodsByBrands(brand,goodses);
    }
    @Transactional
    public List<Good> getGoodsByDatas(String data) {
        return goodsRepository.getGoodsByDatas(data);
    }
    @Transactional
    public List<Good> getAllGoods() {
        return goodsRepository.getAllGoods();
    }
    @Transactional
    public int getPagesCount(List<Good> goodses,int limit) {
        return goodsRepository.getPagesCount(goodses,limit);
    }

    @Transactional
    public void updateGood(Good good) {
        goodsRepository.updateGood(good);
    }

    @Transactional
    public void deleteGood(Good good) {
        goodsRepository.deleteGood(good);
    }
    @Transactional
     public List<Good> getGoodsByCategorysId(Long id) {
        return goodsRepository.getGoodsByCategorysId(id);
    }
    @Transactional
    public List<Good> sortGoods(List<Good> goodses, String type,String direction) {
        return goodsRepository.sortGoodsBy(goodses,type,direction);
    }
    @Transactional
    public List<String> getGoodsBrands() {
        return goodsRepository.getGoodsBrands();
    }
    @Transactional
     public List<String> getGoodsDatas() {
        return goodsRepository.getGoodsDatas();
    }
    @Transactional
    public List<Good> getGoodsByPage(List<Good> goods, int page, int limit) {
        return goodsRepository.getGoodsByPage(goods,page,limit);
    }
    @Transactional
    public Good getGoodsById(Long id) {
        return goodsRepository.getGoodsById(id);
    }
    @Transactional
    public List<Good> getNewGoods() {
        return goodsRepository.getNewGoods();
    }
    @Transactional
    public List<Good> getGoodsByPrice(String costs, List<Good>goodses) {
        return goodsRepository.getGoodsByPrice(costs, goodses);
    }
    @Transactional
    public Integer getMaxPrice(List<Good> goodList) {
        return goodsRepository.getMaxPrice(goodList);
    }
    @Transactional
    public Integer getMinPrice(List<Good> goodList) {
        return goodsRepository.getMinPrice(goodList);
    }
}
