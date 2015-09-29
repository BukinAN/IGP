package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class PriceListRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH p.category").list();

    }


}
