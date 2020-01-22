package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.model.RepositoryPointOfSales;
import pl.edu.wszib.services.IRepositoryPointOfSalesService;

import java.util.Calendar;

@Controller
public class PointOfSalesController {

    @Autowired
    IRepositoryPointOfSalesService repositoryPointOfSalesService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("userModel", new RepositoryPointOfSales());
        return "addProductToRepository";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String register(@ModelAttribute RepositoryPointOfSales repositoryPointOfSales, Model model) {
        repositoryPointOfSales.setDateOfSell(Calendar.getInstance().getTime());
        repositoryPointOfSales.setTotalPrice(repositoryPointOfSales.getAmountOfProduct() * repositoryPointOfSales.getPriceForOneProduct());
        this.repositoryPointOfSalesService.addProductAfterSale(repositoryPointOfSales);
        return "pointOfSalesPage";

    }

    @RequestMapping(value = "/pointOfSalesPage", method = RequestMethod.GET)
    public String pointOfSalesPage() {

        return "pointOfSalesPage";
    }

    @RequestMapping(value = "/reportOfProduct", method = RequestMethod.GET)
    public String reportOfProductPage() {

        return "reportOfProduct";
    }

    @RequestMapping(value = "/averageOfDayOrMonth", method = RequestMethod.GET)
    public String averageOfDayOrMonthPage() {

        return "averageOfDayOrMonth";
    }

    @RequestMapping(value = "/showSalesWithDateFromRepository", method = RequestMethod.POST)
    public String getAllSalesWithDateFromRepository(Model model) {
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getSalesWithDateFromRepository());
        return "salesFromRepository";
    }

    @RequestMapping(value = "/showProductsFromRepository", method = RequestMethod.POST)
    public String getAllProductsFromRepository(Model model) {
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getProductsFromRepository());
        return "salesGroupedByProductAndPoint";
    }

    @RequestMapping(value = "/showSalesWithDateFromRepositoryByPoint", method = RequestMethod.POST)
    public String getAllSalesWithDateFromRepositoryByPoint(@RequestParam("id") int idPointOfSales, Model model) {
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getSalesWithDateFromRepositoryByPoint(idPointOfSales));
        return "salesWithDateFromRepositoryByPoint";
    }

    @RequestMapping(value = "/showProductsFromRepositoryByPoint", method = RequestMethod.POST)
    public String getAllProductsFromRepositoryByPoint(@RequestParam("id") int idPointOfSales, Model model) {
        model.addAttribute("allProducts", this.repositoryPointOfSalesService.getProductsFromRepositoryByPoint(idPointOfSales));
        return "productsFromRepositoryByPoint";
    }

}
