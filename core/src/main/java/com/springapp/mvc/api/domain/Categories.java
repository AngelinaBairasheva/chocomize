package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(nullable = true)
    private String alias;
    @Column(nullable = true)
    private String photo;
    public Categories(Long id,String name, String alias, Categories parent, String photo) {
        this.id=id;
        this.name = name;
        this.parent = parent;
        this.photo=photo;
        this.alias=alias;
    }
    public Categories(Long id,String name, String alias,  String photo) {
        this.id=id;
        this.name = name;
        this.photo=photo;
        this.alias=alias;
    }
    public Categories(Long id,String name, String alias,  Categories parent) {
        this.id=id;
        this.name = name;
        this.parent = parent;
        this.alias=alias;
    }
    public Categories(Long id,String name,String alias) {
        this.id=id;
        this.alias=alias;
        this.name = name;
    }
    public Categories(Long id,String name, Categories parent){
        this.id=id;
        this.name = name;
        this.parent = parent;
    }
public Categories(Long id,String name){
    this.id=id;
    this.name=name;}
    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER,
            mappedBy = "parent")

    private List<Categories> categories;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Categories parent;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<Goods> goodses;

    public Categories() {
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public Categories getParent() {
        return parent;
    }

    public void setParent(Categories parent) {
        this.parent = parent;
    }

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }

}
