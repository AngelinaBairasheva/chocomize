package com.springapp.mvc.api.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
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
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER,
            mappedBy = "parent")

    private List<Category> categories;
    @ManyToOne
            (cascade = {CascadeType.REFRESH},
                    fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Category parent;
    @OneToMany(cascade = CascadeType.REFRESH,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<Good> goodses;
    public Category(Long id, String name, String alias, Category parent, String photo) {
        this.id=id;
        this.name = name;
        this.parent = parent;
        this.photo=photo;
        this.alias=alias;
    }
    public Category(Long id, String name, String alias, String photo) {
        this.id=id;
        this.name = name;
        this.photo=photo;
        this.alias=alias;
    }
    public Category(Long id, String name, String alias, Category parent) {
        this.id=id;
        this.name = name;
        this.parent = parent;
        this.alias=alias;
    }
    public Category(Long id, String name, String alias) {
        this.id=id;
        this.alias=alias;
        this.name = name;
    }
    public Category(Long id, String name, Category parent){
        this.id=id;
        this.name = name;
        this.parent = parent;
    }
public Category(Long id, String name){
    this.id=id;
    this.name=name;}




    public Category() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Good> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Good> goodses) {
        this.goodses = goodses;
    }
    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
