package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServlet;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Обработчик событий на страницах index.jsp и indexError.jsp
 */
@Controller
public class PriceListController extends HttpServlet {

    /**
     * переменная для работы  с репозиторием
     */
    private PriceListRepository pricelistrepository;

    /**
     * конструктор с автозаполнением (от Spring)
     * @param pricelistrepository репозиторий
     */
    @Autowired
    public PriceListController(PriceListRepository pricelistrepository){
        this.pricelistrepository = pricelistrepository;
    }

    /**
     * стартовая страница index.jsp, формирует начальный вывод всего содержимого таблицы prod
     * @param model составной элемент MVC
     * @return направляет на index.jsp
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProducts(Model model){
        List<Product> products = this.pricelistrepository.listAll();
        model.addAttribute("products", products);
        return "index";
    }

    /**
     * обработчик событий поиска
     * @param search сущность, элементы которой заполняются параметрами поиска
     * @param model составной элемент MVC
     * @return возвращает либо на index.jsp, либо на indexError.jsp
     */
    @RequestMapping(value = "/search.form", method = RequestMethod.GET)
    public String selectProduct(@ModelAttribute Search search, Model model){

        //проверка на пустоту всех 4 полей-критериев поска
        if(search.getCategory().isEmpty()==true
                && search.getName().isEmpty()==true
                && search.getPriceFrom().isEmpty()==true
                && search.getPriceTo().isEmpty()==true){
            //если все 4 поля пустые перенапрвит на indexError.jsp
            return "indexError";
        }
        //иначе отправит данные в репозиторий для формирования HQL запроса и получения параметров из БД
        List<Product> products = this.pricelistrepository.loadSearch(search.getCategory(),
                search.getName(), search.getPriceFrom(), search.getPriceTo());
        model.addAttribute("products", products);
        //направит на idex.jsp с отобранными из БД параметрами
        return "index";
    }

}
