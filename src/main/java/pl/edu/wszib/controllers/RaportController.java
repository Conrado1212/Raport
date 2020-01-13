package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.impl.RaportDAOImpl;
import pl.edu.wszib.model.Raport;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class RaportController {

    @Autowired
    RaportDAOImpl raportDAO;
    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/allRaport",method = RequestMethod.GET)
    public String raportPage(Model model, User user){
        model.addAttribute("allRaport",this.raportDAO.getAllRaport());
        if(this.sessionObject.getUser() == null){
            return "redirect:loginPage";
        }
        return "allRaport";
    }
}
