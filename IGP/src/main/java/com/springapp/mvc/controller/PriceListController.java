package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PriceListController extends HttpServlet {

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

    @RequestMapping(value = "/search.form", method = RequestMethod.GET)
    public String selectProduct(@ModelAttribute Search search, Model model){

        List<Product> products = this.pricelistrepository.loadSearch(search.getCategory(),
                search.getName(), search.getPriceFrom(), search.getPriceTo());
        model.addAttribute("products", products);
        return "index";
    }
    /*@RequestMapping(value = "/test.form", method = RequestMethod.GET)
    public String selectProduct(@ModelAttribute("search") Search search, Model model){
        List<Product> products = this.pricelistrepository.loadSearch(search.getCategory(),
                search.getName(), search.getPriceFrom(), search.getPriceTo());
        model.addAttribute("products", products);
        return "index";
    }*/
    //?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8
    /*
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = "";
        String name = "";
        String priceFrom = "";
        String priceTo = "";
        try {

            category = request.getParameter("category");
            search.setCategory(category);
            name = request.getParameter("name");
            search.setName(name);
            priceFrom = request.getParameter("priceFrom");
            search.setPriceFrom(priceFrom);
            priceTo = request.getParameter("priceTo");
            search.setPriceTo(priceTo);
        } catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        dispatcher.forward(request, response);

    }*/
    /*@RequestMapping(value = "/search.form", method = RequestMethod.GET)
    public String selectProduct(Model model){
        List<Product> products = this.pricelistrepository.loadSearch(search.getCategory(),
                search.getName(), search.getPriceFrom(), search.getPriceTo());
        model.addAttribute("products", products);
        return "index";
    }*/

    /*<div>
  <form:form method="post" action="test.form" commandName="search" >
    <table>
      <tr>
      <td><form:label path="category">
        category
      </form:label></td>
      <td><form:input path="category"/></td>
    </tr>
      <tr>
        <td><form:label path="name">
          category
        </form:label>
        </td>
        <td>
          <form:input path="name"/> </td>
      </tr>
      <tr>
        <td><form:label path="priceFrom">
          priceFrom
        </form:label></td>
        <td><form:input path="priceFrom"/></td>
      </tr>
      <tr>
        <td><form:label path="priceTo">
          priceTo
        </form:label>
        </td>
        <td>
          <form:input path="priceTo"/> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="search"/></td>
      </tr>
    </table>
  </form:form>
</div>*/


}
