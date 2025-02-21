package vn.iahsea.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iahsea.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
// @RestController

public class UserController {
    
    @RequestMapping("/")
    public String getHomePage(){
        return "eric.html";
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