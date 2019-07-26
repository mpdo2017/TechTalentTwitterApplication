package com.tts.TechTalentTwitter.controller;

import com.tts.TechTalentTwitter.model.User;
import com.tts.TechTalentTwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/signup")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/signup",method= RequestMethod.GET)
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        // you were missing some getters/setters
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "Username is already taken");
        }

        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success", "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return "registration";
    }
}
