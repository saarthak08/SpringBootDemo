package com.sg.SpringBootDemo.SpringSecurity.controller;

import com.sg.SpringBootDemo.SpringSecurity.model.User;
import com.sg.SpringBootDemo.SpringSecurity.repository.UserRepository;
import com.sg.SpringBootDemo.SpringSecurity.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/register")
@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")
    public String home(){
        return "register";
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(User user, RedirectAttributes redirectAttributes){
        User temp_user=userRepository.findByEmail(user.getEmail());
        if(temp_user!=null){
            redirectAttributes.addFlashAttribute("message", "User already registered..");
            return "redirect:/register/";
        }
        else{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDetailService.saveUser(user);
        }
        redirectAttributes.addFlashAttribute("message", "User created..");
        return "redirect:/register/";
    }
}
