package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Интерпритация таблицы prod в виде сущности (класса)
 */
@Entity
@Table(name="prod")
public class Product {

    /**
     * идентификатор
     */
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    /**
     * наименование товара
     */
    @Column(name="name")
    private String name;

    /**
     * стоимость товара
     */
    @Column(name="price")
    private float price;

    /**
     * параметр для связи с таблицей cat
     */
    @Column(name="cat_id")
    private int cat_id;

    /**
     * связь с таблицей cat через параметр cat_id
     * отношение: многие к одному
     */
    @ManyToOne
    @JoinColumn(name = "cat_id", insertable = false, updatable = false)
    private Category category;


    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return String.valueOf(id)+"  "+name+"  "+String.valueOf(price);
    }
}
