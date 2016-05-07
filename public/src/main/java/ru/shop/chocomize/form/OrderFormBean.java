package ru.shop.chocomize.form;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class OrderFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-zА-Яа-я]+",message = "Введите верное название города")
    private String city;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "[A-Za-zА-Яа-я]+",message = "Введите верное название области")
    private String area;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "\\S.+",message = "Введите верное название улицы")
    private String street;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "\\d{1,6}",message = "Введите верный номер дома")
    private String house;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "\\d{1,6}",message = "Введите верный номер квартиры")
    private String flat;
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "\\d{6}", message = "Введите верный номер индекса")
    private String index;
    @NotEmpty(message = "Выберите способ оплаты")
    private String pay_type;
    public OrderFormBean() {
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}


