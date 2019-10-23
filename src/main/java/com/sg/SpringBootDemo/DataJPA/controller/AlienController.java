package com.sg.SpringBootDemo.DataJPA.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/alien")
public class AlienController {


    @RequestMapping("/view")
    public String home(){
        return "home";
    }

}
