package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Categories;
import com.springapp.mvc.api.domain.Goods;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Goods> getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
    }

    public void addGood(Goods goods) {
        sessionFactory.getCurrentSession().save(goods);
    }

    public void updateGood(Goods goods) {
        sessionFactory.getCurrentSession().update(goods);
    }
    public void deleteGood(Goods goods) {
        sessionFactory.getCurrentSession().delete(goods);
    }
    public List<Goods> getGoodsByCategorysId(Long id) {
        List<Goods> result;
        Categories categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("id", id));
        categories=(Categories) crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category", categories));
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        result=crit2.list();
        return result;
    }
    public List<String> getGoodsBrands() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.isNotNull("brand"));
        crit2.setProjection(Projections.distinct(Projections.property("brand")));
        result=crit2.list();
        System.out.println("rez="+result);
        return result;
    }
    public List<String> getGoodsDatas() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.setProjection(Projections.distinct(Projections.property("bulk_orders")));
        crit2.add(Restrictions.isNotNull("bulk_orders"));
        result=crit2.list();
        System.out.println("ord="+result);
        return result;
    }
    public List<Goods> getGoodsByBrand(String brand) {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("brand", brand));
        result=crit2.list();
        return result;
    }
    public List<Goods> getGoodsByDatas(String data) {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("bulk_orders", data));
        result=crit2.list();
        return result;
    }
    public List<Goods> getGoodsByPage(List<Goods> goods,int page, int limit) {
        System.out.println("goods="+goods);
        List<Goods> result;
        List<Long> goodsId=new ArrayList<>();
        for(Goods goods1:goods){
            goodsId.add(goods1.getId());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.in("id", goodsId));
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        crit2.setMaxResults(limit*page);
        List<Goods> goodses=crit2.list();
        ArrayList<Long> id=new ArrayList<>();
        for(Goods i:goodses){
            id.add(i.getId());
        }

        Criteria crit5 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit5.add(Restrictions.in("id", goodsId));
        int size=crit5.list().size(); //���-�� ������� � ���������
        int maxResult=limit;              //���-�� �������, �������������� �� ��������� ��������
        if(size-limit*page<=0) {
            maxResult = size - limit * (page - 1);
        }
        Criteria crit3 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit3.add(Restrictions.in("id", id));
        crit3.setMaxResults(maxResult);
        List<Goods> goodses1=crit3.list();
        ArrayList<Long> id2=new ArrayList<>();
        for(Goods i:goodses1){
            id2.add(i.getId());
        }
        Criteria crit4 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit4.add(Restrictions.in("id", id2));
        crit4.addOrder(org.hibernate.criterion.Order.desc("id"));
        result=crit4.list();
        return result;
    }
    public Goods getGoodsById(Long id) {
        Goods result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit.add(Restrictions.like("id", id));
        result=(Goods) crit.uniqueResult();
        return result;
    }
    public List<Goods> getNewGoods() {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        crit2.setMaxResults(9);
        result=crit2.list();
        return result;
    }
    public List<String> getTypesOfChocolate() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.setProjection(Projections.distinct(Projections.property("kind")));
        result=crit2.list();
        return result;
    }
    public List<Goods> getChocolatesByKind(String kind) {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("kind", kind));
        result=crit2.list();
        return result;
    }
    public int getPagesCount(List<Goods> goodses,int limit) {
        int result, size;
        List<Long> goodsId=new ArrayList<>();
        for(Goods goods1:goodses){
            goodsId.add(goods1.getId());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.in("id",goodsId));
        size=crit2.list().size();
        if(size%limit!=0){
            result=size/limit+1;
        }else {
            result = size/limit;
        }
        return result;
    }
    public List<Goods> getGoodsByInterval(double start, double end, String catalogName) {
        List<Goods> result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("name",catalogName));
        Categories categories=(Categories)crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category",categories));
        crit2.add(Restrictions.between("price", BigDecimal.valueOf(start),BigDecimal.valueOf(end)));
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        result=crit2.list();
        return result;
    }
    public BigDecimal getMaxPrice(){
        BigDecimal result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.setProjection(Projections.max("price"));
        result=(BigDecimal) crit2.uniqueResult();
        return result;
    }
    public BigDecimal getMinPrice(){
        BigDecimal result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.setProjection(Projections.min("price"));
        result= (BigDecimal) crit2.uniqueResult();
        return result;
    }


}
