package com.sg.SpringBootDemo.SpringSecurityChadDarby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sscd")
public class DemoController {

    @RequestMapping("/")
    public String home(){
        return "home-cd";
    }

}
