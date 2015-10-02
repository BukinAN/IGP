package com.springapp.mvc.repository;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * репозиторий для формирования HQL запросов и отправки результатов их выполнения
 */
@Repository
@Transactional
public class PriceListRepository {

    @Autowired
    private SessionFactory sessionFactory;//фабрика текущей сессии

    /**
     * формирование HQL запроса
     * @param category категория товара
     * @param name наименование товара
     * @param priceFrom стоимость от
     * @param priceTo стоимость до
     * @return возвращает результаты выполнения запроса в виде списка
     */
    public List loadSearch(String category, String name, String priceFrom, String priceTo) {

        if(category.isEmpty()==false
                && name.isEmpty()==true
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==true){
            //если задана только категория
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE pc.name LIKE '%"+category+"%'").list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==false
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==true){
            //если задано только наименование
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%"+name+"%'").list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==true
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==true){
            //если задан только нижний придел стоимости
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.price >= " + priceFrom).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==true
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==false){
            //если задан только верхний придел стоимости
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.price <= " + priceTo).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==true
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==false){
            //если задана стоимость от и до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.price BETWEEN " + priceFrom +" AND " + priceTo).list();
        } else if(category.isEmpty()==false
                && name.isEmpty()==true
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==false){
            //если задана категория и стоимость от и до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE pc.name LIKE '%" + category + "%' AND p.price BETWEEN " + priceFrom + " AND " + priceTo).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==false
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==false){
            //если задано наименование и стоимость от и до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND p.price BETWEEN " + priceFrom+" AND "+priceTo).list();
        } else if(category.isEmpty()==false
                && name.isEmpty()==false
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==false){
            //если заданы все критерии поиска (категория, наименование, стоимость от и до)
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND pc.name LIKE '%" + category + "%' AND p.price BETWEEN " + priceFrom + " AND " + priceTo).list();
        }
        else if(category.isEmpty()==false
                && name.isEmpty()==true
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==true){
            //если задана категория и стоимость от
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE pc.name LIKE '%" + category + "%' AND p.price >= " + priceFrom).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==false
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==false) {
            //если задано наименование и стоимость до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND p.price <= " + priceTo).list();
        } else if(category.isEmpty()==false
                && name.isEmpty()==true
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==false){
            //если задана категория и стоимость до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE pc.name LIKE '%" + category + "%' AND p.price <= " + priceTo).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==false
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==true) {
            //если задано наименование и стоимость от
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND p.price >= " + priceFrom).list();
        }
        else if(category.isEmpty()==false
                && name.isEmpty()==false
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==true){
            //если задана категория, наименование и стоимость от
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND pc.name LIKE '%" + category + "%' AND p.price >= " + priceFrom).list();
        } else if(category.isEmpty()==true
                && name.isEmpty()==false
                && priceFrom.isEmpty()==false
                && priceTo.isEmpty()==false) {
            //если задано наименование и сотимость от и до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND p.price BETWEEN " + priceFrom + " AND " + priceTo).list();
        } else if(category.isEmpty()==false
                && name.isEmpty()==false
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==true){
            //если задана категория и наименование
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND pc.name LIKE '%" + category + "%'").list();
        } else if(category.isEmpty()==false
                && name.isEmpty()==false
                && priceFrom.isEmpty()==true
                && priceTo.isEmpty()==false) {
            //если задана категория, нименование и стоимость до
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH " +
                    "p.category AS pc WHERE p.name LIKE '%" + name + "%' AND pc.name LIKE '%" + category + "%' AND p.price <= " + priceTo).list();
        }
         else {
            //заглушка
            return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH p.category").list();
        }
    }

    /**
     * стартовый список
     * @return возвращает полный перечень товаров
     */
    public List listAll(){
        //формирование стартового списка без критериев поиска
        return this.sessionFactory.getCurrentSession().createQuery("FROM Product AS p INNER JOIN FETCH p.category").list();
    }
}
