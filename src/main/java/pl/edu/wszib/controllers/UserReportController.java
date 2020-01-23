package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.dao.impl.SalesDAOImpl;
import pl.edu.wszib.model.Sales;
import pl.edu.wszib.model.User;
import pl.edu.wszib.model.UserReport;
import pl.edu.wszib.rest.ISaleRest;
import pl.edu.wszib.services.IUserReport;


@Controller
public class UserReportController {

    @Autowired
    SalesDAOImpl salesDAO;

    @Autowired
    IUserReport userReport;

    @Autowired
    ISaleRest saleRest;




    @RequestMapping(value = "/UserReport", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("userID", new UserReport());
        model.addAttribute("errorMessage", "");
        return "UserReportPage";
    }

    @RequestMapping(value = "/UserReport", method = RequestMethod.POST)
    public String authenticateUser(@ModelAttribute("userID") UserReport userReport1, Model model) {
        int authResult = userReport1.getUserID();


        if (!(userReport.getsalesbyUserID(authResult).isEmpty())) {
            model.addAttribute("amountsOfSales3", userReport.getAmountsOfSales(authResult));
            model.addAttribute("sales3", userReport.getUserReportByUserID(authResult));

            return "ReportUserPage";
        } else {

            model.addAttribute("errorMessage", "złe dane !!!");
            model.addAttribute("userID", new Sales());
            return "UserReportPage";
        }
    }
        @RequestMapping(value ="/SalesUpdate", method = RequestMethod.GET)
        public String addSales(){
            saleRest.callAndAddToDAOSales();
            return "redirect:mainPage";
        }



    }




