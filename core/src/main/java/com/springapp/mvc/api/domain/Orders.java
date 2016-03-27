package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
public class Orders {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25)
    private Calendar create_time;
    @Column(nullable = false)
    private BigDecimal total_sum;
    @Column(nullable = false)
    private BigDecimal total_count;
    @Column(nullable = false,length = 50)
    private String status; //доставляется, ожидает получения, доставлен, получен
    @Column(length = 50, nullable = false)
    private String pay_type;


    @ManyToOne

            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany
            (cascade = CascadeType.REFRESH,
                    fetch = FetchType.LAZY)
    @JoinTable(name = "ORDERS_GOODS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GOOD_ID"))
    private List<Goods> goods;
    public Orders(){}

    public Orders(Calendar create_time, BigDecimal total_sum, BigDecimal total_count, String status, String pay_type, Users user, Address address) {
        this.create_time = create_time;
        this.total_sum = total_sum;
        this.total_count = total_count;
        this.status = status;
        this.pay_type = pay_type;
        this.user = user;
        this.address = address;
    }
    public Orders(Calendar create_time, BigDecimal total_sum, BigDecimal total_count, String pay_type, Users user, Address address) {
        this.create_time = create_time;
        this.total_sum = total_sum;
        this.total_count = total_count;
        this.pay_type = pay_type;
        this.user = user;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Calendar create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(BigDecimal total_sum) {
        this.total_sum = total_sum;
    }

    public BigDecimal getTotal_count() {
        return total_count;
    }

    public void setTotal_count(BigDecimal total_count) {
        this.total_count = total_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
