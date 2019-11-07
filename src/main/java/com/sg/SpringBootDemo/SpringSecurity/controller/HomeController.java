package com.sg.SpringBootDemo.SpringSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "login";
    }

    @RequestMapping("/sec")
    public String second(){
        return "sec";
    }

    @RequestMapping("/home-sec")
    public String homesec(){
        return "home-sec";
    }

    @RequestMapping("/logout-success")
    public String logoutPage(){
        return "logout";
    }
}
