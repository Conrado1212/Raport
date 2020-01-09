package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.RaportDAOImpl;
import pl.edu.wszib.model.Raport;

@Controller
public class RaportController {

    @Autowired
    RaportDAOImpl raportDAO;

    @RequestMapping(value = "/allRaport",method = RequestMethod.GET)
    public String raportPage(Model model){
        model.addAttribute("allRaport",this.raportDAO.getAllRaport());
        return "allRaport";
    }
}
