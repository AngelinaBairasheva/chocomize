package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Goods;
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
    public void addGood(Goods goods) {
        goodsRepository.addGood(goods);
    }

    @Transactional
    public List<Goods> getGoodsByBrands(String brand,List<Goods> goodses) {
        return goodsRepository.getGoodsByBrands(brand,goodses);
    }
    @Transactional
    public List<Goods> getGoodsByDatas(String data) {
        return goodsRepository.getGoodsByDatas(data);
    }
    @Transactional
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }
    @Transactional
    public int getPagesCount(List<Goods> goodses,int limit) {
        return goodsRepository.getPagesCount(goodses,limit);
    }

    @Transactional
    public void updateGood(Goods goods) {
        goodsRepository.updateGood(goods);
    }

    @Transactional
    public void deleteGood(Goods goods) {
        goodsRepository.deleteGood(goods);
    }
    @Transactional
     public List<Goods> getGoodsByCategorysId(Long id) {
        return goodsRepository.getGoodsByCategorysId(id);
    }
    @Transactional
    public List<Goods> sortGoods(List<Goods> goodses, String type,String direction) {
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
    public List<Goods> getGoodsByPage(List<Goods> goods, int page, int limit) {
        return goodsRepository.getGoodsByPage(goods,page,limit);
    }
    @Transactional
    public Goods getGoodsById(Long id) {
        return goodsRepository.getGoodsById(id);
    }
    @Transactional
    public List<Goods> getNewGoods() {
        return goodsRepository.getNewGoods();
    }
    @Transactional
    public List<Goods> getGoodsByPrice(String costs, List<Goods>goodses) {
        return goodsRepository.getGoodsByPrice(costs, goodses);
    }
    @Transactional
    public Integer getMaxPrice(Long id) {
        return goodsRepository.getMaxPrice(id);
    }
    @Transactional
    public Integer getMinPrice(Long id) {
        return goodsRepository.getMinPrice(id);
    }
}
