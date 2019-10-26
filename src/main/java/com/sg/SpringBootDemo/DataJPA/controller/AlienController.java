package com.sg.SpringBootDemo.DataJPA.controller;


import com.sg.SpringBootDemo.DataJPA.DAO.AlienRepo;
import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/")
    public String homepage(){
        return "home";
    }


    @GetMapping(value = "/addAlien")
    public String addAlien(Alien alien,RedirectAttributes redirectAttributes){
        try {
            alienRepo.save(alien);
            redirectAttributes.addFlashAttribute("mess", "Added Successfully");
            return "redirect:/";
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("mess", "Failed");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/getAlien")
    @ResponseBody
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

    @RequestMapping(value = "/getAlienXML",produces = {"application/xml","text/xml"})
    @ResponseBody
    public Alien getAlienXML(@RequestParam("id") int id){
        Alien alien=null;
        try {
            alien = alienRepo.findAlienById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
      return alien;
    }

    @RequestMapping(value = "/aliensSorted",produces = "application/json")
    @ResponseBody
    public List<Alien> getJavaAliensSorted(@RequestParam("type") String type){
        return alienRepo.findByTechSorted(type);
    }

    @RequestMapping(value = "/aliens",produces = "application/json")
    @ResponseBody
    public List<Alien> getAliens(){
        return alienRepo.findAll();
    }


    @RequestMapping(value = "/alien/{id}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Optional<Alien> getAliens(@PathVariable("id") int id){
        return alienRepo.findById(id);
    }


    @PostMapping("/updateAlien")
    public ModelAndView updateAlien(Alien alien, RedirectAttributes redirectAttributes, HttpServletResponse response){
        Alien alien2=alienRepo.findAlienById(alien.getId());
        if(alien2!=null){
            alienRepo.save(alien);
            redirectAttributes.addFlashAttribute("message", "Successfully updated..");
            return new ModelAndView("redirect:/");
        }
        else{
            redirectAttributes.addFlashAttribute("message","Error! Data not found!");
            return new ModelAndView("redirect:/");
        }
    }

    @PostMapping(value = "/postAlien",consumes = {"application/json"})
    @ResponseBody
    public Alien addAlienJSON(@RequestBody Alien alien){
        alienRepo.save(alien);
        return alien;
    }


    @DeleteMapping("/deleteAlien/{id}")
    public String deleteAlien(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        try {
            alienRepo.deleteById(id);
            redirectAttributes.addFlashAttribute("delete", "Successfully deleted..");
            return "redirect:/";
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("delete", "Error!");
            return "redirect:/";
        }
    }
}
