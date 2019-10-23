package com.sg.SpringBootDemo.DataJPA.controller;


import com.sg.SpringBootDemo.DataJPA.DAO.AlienRepo;
import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/view")
    public String home(){
        return "home";
    }


    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        alienRepo.save(alien);
        return "home";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam("id") int id, ModelAndView modelAndView){
        Alien alien=null;
        try {
            alien = alienRepo.findAlienById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        modelAndView.addObject("alien",alien);
        modelAndView.setViewName("alien");
        return modelAndView;
    }
}
