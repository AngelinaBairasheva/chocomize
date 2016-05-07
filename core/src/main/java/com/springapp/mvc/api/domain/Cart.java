package com.springapp.mvc.api.domain;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints= @UniqueConstraint(columnNames = {"good_id", "user_id"}) )
public class Cart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 4)
    private Integer count;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    private Good good;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart(Integer count, Good good, User user) {

        this.count = count;
        this.good = good;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", count=" + count +
                ", good=" + good +
                ", user=" + user +
                '}';
    }
}

