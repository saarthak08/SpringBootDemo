package com.sg.SpringBootDemo.SpringSecurity;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home-sec";
    }

    @RequestMapping("/sec")
    public String second(){
        return "sec";
    }


    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/logout-success")
    public String logoutPage(){
        return "logout";
    }
}
