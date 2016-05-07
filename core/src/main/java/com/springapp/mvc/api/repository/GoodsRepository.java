package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Category;
import com.springapp.mvc.api.domain.Good;
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
    public List<Good> getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Good.class).list();
    }

    public void addGood(Good good) {
        sessionFactory.getCurrentSession().save(good);
    }

    public void updateGood(Good good) {
        sessionFactory.getCurrentSession().update(good);
    }

    public void deleteGood(Good good) {
        sessionFactory.getCurrentSession().delete(good);
    }


    public List<Good> sortGoodsBy(List<Good> goodses, String type, String direction) {
        List<Good> result = null;
        if (goodses != null && !goodses.isEmpty()) {
            List<Long> goodsId = new ArrayList<>();
            for (Good good1 : goodses) {
                goodsId.add(good1.getId());
            }
            Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
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
        }
        return result;
    }

    public List<String> getGoodsBrands() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit2.add(Restrictions.isNotNull("brand"));
        crit2.setProjection(Projections.distinct(Projections.property("brand")));
        result = crit2.list();
        return result;
    }

    public List<String> getGoodsDatas() {
        List<String> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit2.setProjection(Projections.distinct(Projections.property("bulk_orders")));
        crit2.add(Restrictions.isNotNull("bulk_orders"));
        result = crit2.list();
        return result;
    }

    public List<Good> getGoodsByBrands(String brands, List<Good> goodses) {
        List<Good> result;
        if (goodses != null && !goodses.isEmpty() && brands != null && !brands.equals("[]")) {
            String s = brands.replaceAll("[\\[\"\\]]", "");
            String[] b = s.split(",\\s*");
            List<Long> goodsIds = new ArrayList<>();
            for (Good good1 : goodses) {
                goodsIds.add(good1.getId());
            }
            Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(Good.class);
            crit1.add(Restrictions.in("id", goodsIds));
            crit1.add(Restrictions.in("brand", b));
            result = crit1.list();
        } else {
            result = goodses;
        }
        return result;
    }

    public List<Good> getGoodsByDatas(String data) {
        List<Good> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit2.add(Restrictions.like("bulk_orders", data));
        result = crit2.list();
        return result;
    }

    public List<Good> getGoodsByPage(List<Good> goods, int page, int limit) {
        List<Good> result = null;
        if (goods != null && !goods.isEmpty()) {
            List<Good> newGoods = new LinkedList<>();
            int maxRez = limit * page;
            int size = goods.size(); //���-�� ������� � ���������
            int maxResult = limit;              //���-�� �������, �������������� �� ��������� ��������
            if (size - limit * page <= 0) {
                maxResult = size - limit * (page - 1);
            }
            //int r = maxRez - maxResult - 2;
            /*if (r < 0) {
                r = 0;
                //maxRez;
            }*/
            int k = Math.min(maxRez, goods.size());
            for (int i = limit * (page - 1); i < k; i++) {
                newGoods.add(goods.get(i));
            }
            result = newGoods;
        }
        return result;
    }

    public Good getGoodsById(Long id) {
        Good result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit.add(Restrictions.like("id", id));
        result = (Good) crit.uniqueResult();
        return result;
    }

    public List<Good> getNewGoods() {
        List<Good> result;
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        crit2.setMaxResults(9);
        result = crit2.list();
        return result;
    }

    public int getPagesCount(List<Good> goodses, int limit) {
        int result = 0;
        int size;
        if (goodses != null && !goodses.isEmpty()) {
            List<Long> goodsId = new ArrayList<>();
            for (Good good1 : goodses) {
                goodsId.add(good1.getId());
            }
            Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
            crit2.add(Restrictions.in("id", goodsId));
            size = crit2.list().size();
            if (size % limit != 0) {
                result = size / limit + 1;
            } else {
                result = size / limit;
            }
        }
        return result;
    }

    public List<Good> getGoodsByPrice(String costs, List<Good> goodses) {
        List<Good> result;
        costs = costs.replaceAll("\"", "");
        String[] rez = costs.split(",");
        Integer start = Integer.valueOf(rez[0]);
        Integer end = Integer.valueOf(rez[1]);
        List<Long> goodsIds = new ArrayList<>();
        for (Good good1 : goodses) {
            goodsIds.add(good1.getId());
        }
        BigDecimal s = BigDecimal.valueOf(start);
        BigDecimal e = BigDecimal.valueOf(end);
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit2.add(Restrictions.in("id", goodsIds));
        crit2.add(Restrictions.between("price", s, e));
        result = crit2.list();
        return result;
    }

    public Integer getMaxPrice(List<Good> goodList) {
        Integer result;
        BigDecimal r;
        List<Long> goodsesIds = new ArrayList<>();
        for (Good good : goodList) {
            goodsesIds.add(good.getId());
        }
        Criteria crit3 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit3.add(Restrictions.in("id", goodsesIds));
        crit3.setProjection(Projections.max("price"));
        r = (BigDecimal) crit3.uniqueResult();
        result = r.intValue();
        return result;
    }

    public Integer getMinPrice(List<Good> goodList) {
        Integer result;
        BigDecimal r;
        List<Long> goodsesIds = new ArrayList<>();
        for (Good good : goodList) {
            goodsesIds.add(good.getId());
        }
        Criteria crit3 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        crit3.add(Restrictions.in("id", goodsesIds));
        crit3.setProjection(Projections.min("price"));
        r = (BigDecimal) crit3.uniqueResult();
        result = r.intValue();
        return result;
    }

    public List<Good> getGoodsByCategorysId(Long id) {
        List<Category> temp = new ArrayList<>();

        Criteria criteria12 = sessionFactory.getCurrentSession().createCriteria(Category.class);
        criteria12.add(Restrictions.like("id", id));
        Category category12 = (Category) criteria12.uniqueResult();

        List<Good> result;
        List<Category> children;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
        criteria.add(Restrictions.like("parent", category12));
        children = criteria.list();

        if (!children.isEmpty()) {
            temp = recursion(children);
            res=new ArrayList<>();
        } else {
            temp.add(category12);
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Good.class);
        if (temp.size() == 1) {
            crit2.add(Restrictions.like("category", temp.get(0)));

        } else {
            crit2.add(Restrictions.in("category", temp));

        }
        crit2.addOrder(org.hibernate.criterion.Order.desc("id"));
        result = crit2.list();
        return result;
    }

    public static List<Category> res = new ArrayList<>();

    private List<Category> recursion(List<Category> children) {
        List<Category> ca;
        for (Category cc : children) {
            Criteria crite = sessionFactory.getCurrentSession().createCriteria(Category.class);
            crite.add(Restrictions.like("parent", cc));
            ca = crite.list();
            if (ca.isEmpty()) {
                res.add(cc);
            } else {
                recursion(ca);
            }
        }
        return res;
    }
}
