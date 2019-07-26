package com.tts.TechTalentTwitter.controller;

import com.tts.TechTalentTwitter.model.Tweet;
import com.tts.TechTalentTwitter.model.User;
import com.tts.TechTalentTwitter.service.TweetService;
import com.tts.TechTalentTwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Controller
public class TweetController {
    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;


    @GetMapping({"/tweets", "/"})
    public String getFeed(Model model) {
        List<Tweet> tweets = tweetService.findAll();
        model.addAttribute("tweetList", tweets);
        return "feed";
    }

    @GetMapping("/tweets/new")
    public String getTweetForm(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "newTweet";
        //* serve up the new tweet page, newTweet.html
    }

    @PostMapping("/tweets")
    public String submitTweetForm(@Valid Tweet tweet, BindingResult bindingResult, Model model) {
        User user = userService.getLoggedInUser(tweet.getUser());
        if (!bindingResult.hasErrors()) {
            tweet.setUser(user);
            tweetService.save(tweet);
            model.addAttribute("successMessage", "Tweet successfully created!");
            model.addAttribute("tweet", new Tweet());
        }
        return "newTweet";
        //*handles the form submission from new tweet page. Gets the logged in user and associates them with the tweets.
    }
}