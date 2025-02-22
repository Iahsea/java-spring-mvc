package vn.iahsea.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iahsea.laptopshop.domain.User;
import vn.iahsea.laptopshop.repository.UserRepository;
import vn.iahsea.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
// @RestController

public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")  
    public String getHomePage(Model model){
        List<User> arrUsers = this.userService.getAllUsersByEmail("iah@gmail.com");
        System.out.println(arrUsers);
        model.addAttribute("eric", "hi");
        model.addAttribute("iahsea", "This is Iahsea");
        return "hello";
    }
    
    @RequestMapping("/admin/user")  
    public String getUserPage(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users1", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/create")  
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "admin/user/create", method = RequestMethod.POST)  
    public String createUserPage(Model model, @ModelAttribute("newUser") User iahsea){
        this.userService.handleSaveUser(iahsea);
        return "redirect:/admin/user";
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