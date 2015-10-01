package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Product;
import com.springapp.mvc.domain.Search;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Repository
@Transactional
public class PriceListRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private Search search;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public List loadSearch(String category, String name, String priceFrom, String priceTo) {

        if(!(name.isEmpty())) {

            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%"+name+"%'").list();
        } else {
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH p.category").list();
        }
    }

    public List listAll(){
        //searc.
        return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH p.category").list();
    }
    /*
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     */
}
