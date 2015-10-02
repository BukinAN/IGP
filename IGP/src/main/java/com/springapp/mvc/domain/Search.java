package com.springapp.mvc.domain;


/**
 * класс для реализации поискового запроса
 */
public class Search {

    /**
     * категория
     */
    private String category;
    /**
     * наименование
     */
    private String name;
    /**
     * стоимость от
     */
    private String priceFrom;
    /**
     * стоимость до
     */
    private String priceTo;

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
