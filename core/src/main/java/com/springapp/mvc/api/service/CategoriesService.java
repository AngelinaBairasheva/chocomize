package com.springapp.mvc.api.service;

import com.springapp.mvc.api.domain.Category;
import com.springapp.mvc.api.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public List<Category> getAllCategories() {
        return categoriesRepository.getAllCategories();
    }

    @Transactional
    public void addCategory(Category category) {
        categoriesRepository.addCategory(category);
    }

    @Transactional
    public void updateCategory(Category category) {
        categoriesRepository.updateCategory(category);
    }

    @Transactional
    public List<Category> getRootCategories() {
        return categoriesRepository.getRootCategories();
    }
    @Transactional
    public List<Category> getEndedCategories() {
        return categoriesRepository.getEndedCategories();
    }
    @Transactional
    public Category getCategoryById(Long id) {
        return categoriesRepository.getCategoryById(id);
    }

    @Transactional
    public void deleteCategory(Category category) {
        categoriesRepository.deleteCategory(category);
    }
    @Transactional
    public Category getCategoryByName(String name) {
        return categoriesRepository.getCategoryByName(name);
    }
}

