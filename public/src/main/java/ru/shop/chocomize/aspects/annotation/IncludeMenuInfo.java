package ru.shop.chocomize.aspects.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �� ���� ��������� � request ����������� ������ ��������� ��� ���� �� MainMenuAspect
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IncludeMenuInfo {
}
