package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Интерпритация таблицы cat в виде сущности (класса)
 */
@Entity
@Table(name="cat")
public class Category {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    /**
     * наименование категории
     */
    @Column(name="name")
    private String name;

    /**
     * связь с таблицей prod через id
     * отношение: один ко многим
     */
    @OneToMany(mappedBy="category")
    private Set<Product> products = new HashSet<Product>();

    public Category() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
