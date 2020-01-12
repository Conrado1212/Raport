package pl.edu.wszib.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String mainSite(){
        return "redirect:loginPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";

    }
    @RequestMapping(value = "/loginPage",method = RequestMethod.POST)
    public String authorization(@ModelAttribute User user){
        if(user.getLogin().equals("admin")&& user.getPass().equals("admin")){
            System.out.println("Witaj jestes zalogowany w systemie ");
            this.sessionObject.setUser(user);
            return "redirect:mainPage";
        }
        return "loginPage";
    }

    @RequestMapping(value = "/mainPage",method = RequestMethod.GET)
    public String page(Model model){
        if(this.sessionObject.getClass()==null){
            return "redirect:loginPage";
        }
        model.addAttribute("loginPage",this.sessionObject.getUser().getLogin());
        return "mainPage";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        this.sessionObject.setUser(null);
        return "redirect:loginPage";
    }

}
