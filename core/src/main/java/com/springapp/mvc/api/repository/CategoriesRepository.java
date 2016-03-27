package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Categories;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriesRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Categories> getAllCategories() {
        return sessionFactory.getCurrentSession().createCriteria(Categories.class).list();
    }

    public void addCategory(Categories category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public void updateCategory(Categories category) {
        sessionFactory.getCurrentSession().update(category);
    }

    public Categories getCategoryById(Long id) {
        return (Categories) sessionFactory.getCurrentSession().load(Categories.class, id);
    }

    public void deleteCategory(Categories category) {
        sessionFactory.getCurrentSession().delete(category);
    }
    public List<Categories> getEndedCategories() {
        List<Categories> result;
        List<String> parentsNames=new ArrayList<>();
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.setProjection(Projections.distinct(Projections.property("parent")));
        List<Categories> parents=crit.list();
        for(Categories categories:parents){
            if(categories!=null)
            parentsNames.add(categories.getName());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit2.add(Restrictions.not(Restrictions.in("name", parentsNames)));
        result=crit2.list();
        return result;
    }
    public List<Categories> getRootCategories() {
        List<Categories> categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.isNull("parent"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        categories =  crit.list();
        return categories;
    }
    public Categories getCategoryByName(String name) {
        Categories result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        crit.add(Restrictions.like("name", name));
        result=(Categories) crit.uniqueResult();
        return result;
    }
}
