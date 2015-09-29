package com.springapp.mvc.domain;

import javax.persistence.*;

@Entity
@Table(name="prod")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int iD;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;

    @Column(name="cat_id")
    private int cat_id;

    @ManyToOne
    @JoinColumn(name="cat_id")
    private Category category;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getId() {
        return iD;
    }

    public void setId(int iD) {
        this.iD = iD;
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
        return String.valueOf(iD)+"  "+name+"  "+String.valueOf(price);
    }
}
