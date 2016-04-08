package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 4)
    private Integer house;
    @Column(length = 4)
    private Integer flat;
    @Column(nullable = false)
    private String city;
    private String street;
                      private String area;





    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy="address")
    private List<Orders> orderses;
    public Address(){}

    public Address(Integer house, Integer flat, String city, String street,  String area, Users user) {
        this.house = house;
        this.flat = flat;
        this.city = city;
        this.street = street;
        this.area = area;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }
}
