package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Goods;
import com.springapp.mvc.api.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public List<String> getTypesOfChocolate() {
        return goodsRepository.getTypesOfChocolate();
    }
    @Transactional
    public List<Goods> getGoodsByBrand(String brand) {
        return goodsRepository.getGoodsByBrand(brand);
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
    public List<String> getGoodsBrands() {
        return goodsRepository.getGoodsBrands();
    }@Transactional
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
    public List<Goods> getGoodsByInterval(double start,double end, String catalogName) {
        return goodsRepository.getGoodsByInterval(start, end, catalogName);
    }
    @Transactional
    public BigDecimal getMaxPrice() {
        return goodsRepository.getMaxPrice();
    }
    @Transactional
    public BigDecimal getMinPrice() {
        return goodsRepository.getMinPrice();
    }

    @Transactional
    public List<Goods> getChocolatesByKind(String kind) {
        return goodsRepository.getChocolatesByKind(kind);
    }
}
