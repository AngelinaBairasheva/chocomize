package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
    public class Users {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(nullable = false)
        private Integer hash_passport;
        @Column(length = 50, unique = true, nullable = false)
        private String login;
        @Column(nullable = true)
        private String avatar;
        @Column(name = "name", nullable = false)
        private String name;
        @Column(name = "secondName", nullable = false)
        private String secondName;
        @Column(name = "middleName", nullable = false)
        private String middleName;
        @Column(columnDefinition = "boolean default false")
        private Boolean check;
        @Column(nullable = false, unique = true)
        private Long key;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Orders> orderses;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Cart> carts;
    public Users(){}

    public Users(Integer hash_passport, String login, String avatar, String name, String secondName, String middleName, Boolean check, Long key) {
        this.hash_passport = hash_passport;
        this.login = login;
        this.avatar = avatar;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.check = check;
        this.key = key;
    }

    public Users(Integer hash_passport, String login, String name, String secondName, String middleName, Boolean check, Long key) {
        this.hash_passport = hash_passport;
        this.login = login;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.check = check;
        this.key = key;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHash_passport() {
        return hash_passport;
    }

    public void setHash_passport(Integer hash_passport) {
        this.hash_passport = hash_passport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Orders> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Orders> orderses) {
        this.orderses = orderses;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
