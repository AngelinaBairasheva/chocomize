package com.springapp.mvc.api.repository;

import com.springapp.mvc.api.domain.Category;
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
    public List<Category> getAllCategories() {
        return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
    }

    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public void updateCategory(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

    public Category getCategoryById(Long id) {
        return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    }

    public void deleteCategory(Category category) {
        sessionFactory.getCurrentSession().delete(category);
    }
    public List<Category> getEndedCategories() {
        List<Category> result;
        List<Long> parentsIds=new ArrayList<>();
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Category.class);
        crit.add(Restrictions.isNotNull("parent"));
        crit.setProjection(Projections.distinct(Projections.property("parent")));
        List<Category> parents=crit.list();
        for(Category category :parents){
            if(category !=null)
                parentsIds.add(category.getId());
        }
        Criteria crit2 = sessionFactory.getCurrentSession().createCriteria(Category.class);
        crit2.add(Restrictions.not(Restrictions.in("id", parentsIds)));
        result=crit2.list();
        return result;
    }
    public List<Category> getRootCategories() {
        List<Category> categories;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Category.class);
        crit.add(Restrictions.isNull("parent"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        categories =  crit.list();
        return categories;
    }
    public Category getCategoryByName(String name) {
        Category result;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Category.class);
        crit.add(Restrictions.like("name", name));
        result=(Category) crit.uniqueResult();
        return result;
    }
}
