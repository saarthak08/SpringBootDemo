package com.sg.SpringBootDemo.SpringSecurity.controller;

import com.sg.SpringBootDemo.SpringSecurity.model.Privilege;
import com.sg.SpringBootDemo.SpringSecurity.model.Role;
import com.sg.SpringBootDemo.SpringSecurity.repository.RoleRepository;
import com.sg.SpringBootDemo.SpringSecurity.repository.UserRepository;
import com.sg.SpringBootDemo.SpringSecurity.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/check")
    public ModelAndView check(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=(User)auth.getPrincipal();
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        modelAndView.clear();
        com.sg.SpringBootDemo.SpringSecurity.model.User u=userRepository.findByEmail(user.getUsername());
        if(Arrays.asList(u.getRoles().toArray()).equals(Arrays.asList(adminRole))){
            modelAndView.addObject("user",u);
            modelAndView.setViewName("admin-home");
        }
        else{
            modelAndView.addObject("user",u);
            modelAndView.setViewName("home-sec");
        }
        return modelAndView;
    }
}
