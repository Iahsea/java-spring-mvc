package vn.iahsea.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iahsea.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
// @RestController

public class UserController {

    private UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")  
    public String getHomePage(Model model){
        String test = this.userService.handleHello();
        model.addAttribute("eric", test);
        model.addAttribute("iahsea", "This is Iahsea");
        return "hello";
    }
    
}


// public class UserController {

    // private UserService userService;

    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }


    // @GetMapping("")
    // public String getHomePage(){
    //     return this.userService.handleHello();
    //     // return "hello";
    // }
    
    
// }