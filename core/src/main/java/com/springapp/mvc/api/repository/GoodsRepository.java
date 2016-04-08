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
import java.util.LinkedList;
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
        categories = (Categories) crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category", categories));
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        result = crit2.list();
        return result;
    }

    public List<Goods> sortGoodsBy(List<Goods> goodses, String type, String direction) {
        List<Goods> result;
        List<Long> goodsId = new ArrayList<>();
        for (Goods goods1 : goodses) {
            goodsId.add(goods1.getId());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.in("id", goodsId));
        if (type.equals("pstn")) {
            if (direction.equals("asc")) {
                crit2.addOrder(org.hibernate.criterion.Order.asc("id"));
            } else {
                crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
            }
        }
        if (type.equals("Name")) {
            if (direction.equals("asc")) {
                crit2.addOrder(org.hibernate.criterion.Order.asc("name"));
            } else {
                crit2.addOrder(org.hibernate.criterion.Order.desc("name"));
            }
        }
        if (type.equals("Price")) {
            if (direction.equals("asc")) {
                crit2.addOrder(org.hibernate.criterion.Order.asc("price"));
            } else {
                crit2.addOrder(org.hibernate.criterion.Order.desc("price"));
            }
        }
        result = crit2.list();
        return result;
    }

    public List<String> getGoodsBrands() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.isNotNull("brand"));
        crit2.setProjection(Projections.distinct(Projections.property("brand")));
        result = crit2.list();
        return result;
    }

    public List<String> getGoodsDatas() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.setProjection(Projections.distinct(Projections.property("bulk_orders")));
        crit2.add(Restrictions.isNotNull("bulk_orders"));
        result = crit2.list();
        return result;
    }

    public List<Goods> getGoodsByBrands(String brands, List<Goods> goodses) {
        List<Goods> result;
        if ( brands!=null && !brands.equals("[]")) {
            String s = brands.replaceAll("[\\[\"\\]]", "");
            String[] b = s.split(",\\s*");
            List<Long> goodsIds = new ArrayList<>();
            for (Goods goods1 : goodses) {
                goodsIds.add(goods1.getId());
            }
            Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
            crit1.add(Restrictions.in("id", goodsIds));
            crit1.add(Restrictions.in("brand", b));
            result = crit1.list();
        } else {
            result = goodses;
        }
        return result;
    }

    public List<Goods> getGoodsByDatas(String data) {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("bulk_orders", data));
        result = crit2.list();
        return result;
    }

    public List<Goods> getGoodsByPage(List<Goods> goods, int page, int limit) {
        List<Goods> result;
        List<Goods> newGoods = new LinkedList<>();
        List<Long> goodsId = new ArrayList<>();


        int maxRez = limit * page;
        int size = goods.size(); //���-�� ������� � ���������
        int maxResult = limit;              //���-�� �������, �������������� �� ��������� ��������
        if (size - limit * page <= 0) {
            maxResult = size - limit * (page - 1);
        }
        int r = maxRez - maxResult - 2;
        if (r < 0) {
            r = 0;
            //maxRez;
        }
        int k = Math.min(maxRez, goods.size());
        for (int i = limit * (page - 1); i < k; i++) {
            newGoods.add(goods.get(i));
        }
        result = newGoods;
        return result;
    }

    public Goods getGoodsById(Long id) {
        Goods result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit.add(Restrictions.like("id", id));
        result = (Goods) crit.uniqueResult();
        return result;
    }

    public List<Goods> getNewGoods() {
        List<Goods> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        crit2.setMaxResults(9);
        result = crit2.list();
        return result;
    }

    public int getPagesCount(List<Goods> goodses, int limit) {
        int result, size;
        List<Long> goodsId = new ArrayList<>();
        for (Goods goods1 : goodses) {
            goodsId.add(goods1.getId());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.in("id", goodsId));
        size = crit2.list().size();
        if (size % limit != 0) {
            result = size / limit + 1;
        } else {
            result = size / limit;
        }
        return result;
    }

    public List<Goods> getGoodsByPrice(String costs, List<Goods> goodses) {
        List<Goods> result;
        String[] rez = costs.split(",");
        Integer start = Integer.valueOf(rez[0]);
        Integer end = Integer.valueOf(rez[1]);
        List<Long> goodsIds = new ArrayList<>();
        for (Goods goods1 : goodses) {
            goodsIds.add(goods1.getId());
        }
        BigDecimal s = BigDecimal.valueOf(start);
        BigDecimal e = BigDecimal.valueOf(end);
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.in("id", goodsIds));
        crit2.add(Restrictions.between("price", s, e));
        result = crit2.list();
        return result;
    }

    public Integer getMaxPrice(Long id) {
        Integer result;
        BigDecimal r;
        List<Long> goodsesIds;
        Categories categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("id", id));
        categories = (Categories) crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category", categories));
        crit2.setProjection(Projections.distinct(Projections.property("id")));
        goodsesIds = crit2.list();
        Criteria crit3 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit3.add(Restrictions.in("id", goodsesIds));
        crit3.setProjection(Projections.max("price"));
        r = (BigDecimal) crit3.uniqueResult();
        result = r.intValue();
        return result;
    }

    public Integer getMinPrice(Long id) {
        Integer result;
        BigDecimal r;
        List<Long> goodsesIds;
        Categories categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("id", id));
        categories = (Categories) crit.uniqueResult();
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit2.add(Restrictions.like("category", categories));
        crit2.setProjection(Projections.distinct(Projections.property("id")));
        goodsesIds = crit2.list();
        Criteria crit3 = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        crit3.add(Restrictions.in("id", goodsesIds));
        crit3.setProjection(Projections.min("price"));
        r = (BigDecimal) crit3.uniqueResult();
        result = r.intValue();
        return result;
    }


}
