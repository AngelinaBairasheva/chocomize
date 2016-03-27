package ru.shop.chocomize.aspects;

import com.springapp.mvc.api.service.CategoriesService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Аспект для добавления списка категорий в меню шапки и подвала сайта
 *
 */
@Aspect
@Component
public class MainMenuAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoriesService categoriesService;

    @Pointcut("@annotation(ru.shop.chocomize.aspects.annotation.IncludeMenuInfo)")
    public void includeMenuMethod() {
    }

    @Before("includeMenuMethod()")
    public void includeMenuInfo() {
        request.setAttribute("rootCategories", categoriesService.getRootCategories());
        request.setAttribute("endedCategories", categoriesService.getEndedCategories());
    }
}
