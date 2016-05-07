package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 4)
    private Integer house;
    @Column(nullable = false,length = 4)
    private Integer flat;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String area;
    @Column(nullable = false,length = 10)
    private Integer ad_index;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "address")
    private List<Order> orderses;

    public Address() {
    }

    public Address(Integer index, Integer house, Integer flat, String city, String street, String area, User user) {
        this.ad_index = index;
        this.house = house;
        this.flat = flat;
        this.city = city;
        this.street = street;
        this.area = area;
        this.user = user;
    }


    public Integer getIndex() {
        return ad_index;
    }

    public void setIndex(Integer index) {
        this.ad_index = index;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Order> orderses) {
        this.orderses = orderses;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", house=" + house +
                ", flat=" + flat +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", index=" + ad_index +
                ", user=" + user +
                ", orderses=" + orderses +
                '}';
    }
}
