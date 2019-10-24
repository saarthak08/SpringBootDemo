package com.sg.SpringBootDemo.DataJPA.controller;


import com.sg.SpringBootDemo.DataJPA.DAO.AlienRepo;
import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        System.out.println(alienRepo.findByTechSorted("Java"));
        modelAndView.addObject("alien",alien);
        modelAndView.setViewName("alien");
        return modelAndView;
    }

    @RequestMapping("/aliensSorted/{type}")
    @ResponseBody
    public List<Alien> getJavaAliensSorted(@PathVariable("type") String type){
        return alienRepo.findByTechSorted(type);
    }

    @RequestMapping("/aliens")
    @ResponseBody
    public String getAliens(){
        return alienRepo.findAll().toString();
    }


    @RequestMapping(value = "/alien/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getAliens(@PathVariable("id") int id){
        return alienRepo.findById(id).toString();
    }


    @RequestMapping(value = "/updateAlien",method = RequestMethod.POST)
    public ModelAndView updateAlien(Alien alien, RedirectAttributes redirectAttributes, HttpServletResponse response){
        Alien alien2=alienRepo.findAlienById(alien.getId());
        if(alien2!=null){
            alienRepo.save(alien);
            redirectAttributes.addFlashAttribute("message", "Successfully updated..");
            return new ModelAndView("redirect:/view");
        }
        else{
            redirectAttributes.addFlashAttribute("message","Error! Data not found!");
            return new ModelAndView("redirect:/view");
        }
    }
}
