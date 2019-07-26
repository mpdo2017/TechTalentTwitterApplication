package com.tts.TechTalentTwitter.controller;

import com.tts.TechTalentTwitter.model.Tweet;
import com.tts.TechTalentTwitter.model.User;
import com.tts.TechTalentTwitter.service.TweetService;
import com.tts.TechTalentTwitter.service.UserService;
import com.tts.TechTalentTwitter.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;

/**
 * @author Michele Lanning
 * @version 2019-07-24
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping("/users/{username}")
    public String getUser(@PathVariable("username") String username, Model model) {
        User user = userService.findByUsername(username);
        List<Tweet> tweets = tweetService.findAllByUser(user);
        model.addAttribute("tweetList", tweets);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        SetTweetCounts(users, model);
        return "users";
    }

    private void SetTweetCounts(List<User> users, Model model) {
    }

}
