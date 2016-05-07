package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String hash_password;
    @Column(length = 50, unique = true, nullable = false)
    private String login;
    private String avatar="resources/i/avatar_720-vflYJnzBZ.png";
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "secondName", nullable = false)
    private String secondName;
    @Column(name = "middleName", nullable = false)
    private String middleName;
    private String phone;

    /**
     * Флаг, что пользователь подтвержден и активен.
     */
    @Column
    private Boolean enabled=false;
    /**
     * Уникальный ключ для подтверждения пользователя, отправляется по почте
     */
    @Column(unique = true)
    private Long us_key;
    /**
     * Права доступа пользователя (возможные значения 'ROLE_USER', 'ROLE_ADMIN')
     */
    private String role;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Order> orderses;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Cart> carts;

    public User() {
    }

    public User(String hash_passport, String login, String name, String secondName, String middleName, String phone, Boolean enabled) {
        this.hash_password = hash_passport;
        this.login = login;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.enabled = enabled;
    }

    public User(String hash_passport, String login, String avatar, String name, String secondName, String middleName, String phone, Boolean enabled, Long key, String role, List<Address> addresses) {
        this.hash_password = hash_passport;
        this.login = login;
        this.avatar = avatar;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.enabled = enabled;
        this.us_key = key;
        this.role = role;
        this.addresses = addresses;
    }

    public User(String hash_passport, String login, String avatar, String name, String secondName, String middleName, Boolean check, Long key) {
        this.hash_password = hash_passport;
        this.login = login;
        this.avatar = avatar;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.enabled = check;
        this.us_key = key;
    }

    public User(String hash_passport, String login, String name, String secondName, String middleName, Boolean check, Long key) {
        this.hash_password = hash_passport;
        this.login = login;
        this.name = name;
        this.secondName = secondName;
        this.middleName = middleName;
        this.enabled = check;
        this.us_key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }

    public String getLogin() {
        return login;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getKey() {
        return us_key;
    }

    public void setKey(Long key) {
        this.us_key = key;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrderses() {
        return orderses;
    }

    public void setOrderses(List<Order> orderses) {
        this.orderses = orderses;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", hash_passport='" + hash_password + '\'' +
                ", login='" + login + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                ", key=" + us_key +
                ", role='" + role + '\'' +
                '}';
    }
}
