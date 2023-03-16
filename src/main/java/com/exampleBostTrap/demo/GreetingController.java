package com.exampleBostTrap.demo;

import com.exampleBostTrap.demo.domain.User;
import com.exampleBostTrap.demo.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    private UserRepos userRepos;
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users",userRepos.findAll());
        model.addAttribute("updateUser",new User());
        return "Users";
    }
    @PostMapping(value = "/del")
    public String delUser(@RequestParam int id, ModelMap model){
        userRepos.delete(userRepos.findAllById(id));
        return "redirect:/";
    }
    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("updateUser")User user){
        userRepos.save(user);
        return "redirect:/";
    }
    //Я не могу понять откуда у меня появляються запятые перед firstName & lastName при выполнении update&add
    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("updateUser")User user){
        userRepos.save(user);
        return "redirect:/";
    }

}
