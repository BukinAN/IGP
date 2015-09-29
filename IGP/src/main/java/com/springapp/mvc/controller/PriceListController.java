package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PriceListController {

    private PriceListRepository pricelistrepository;

    @Autowired
    public PriceListController(PriceListRepository pricelistrepository){
        this.pricelistrepository = pricelistrepository;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getProducts(Model model){
        List<Product> products = this.pricelistrepository.listAll();
        model.addAttribute("products", products);
        return "index";
    }
}
