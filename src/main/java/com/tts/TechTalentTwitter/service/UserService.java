package com.tts.TechTalentTwitter.service;

import com.tts.TechTalentTwitter.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tts.TechTalentTwitter.repository.RoleRepository;
import com.tts.TechTalentTwitter.repository.UserRepository;
import com.tts.TechTalentTwitter.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Michele Lanning
 * @version 2019-07-22
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {

        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {

        userRepository.save(user);
    }

    public User getLoggedInUser(User user) {
        userRepository.findByUsername(user.getUsername());
        // you'll have to create and implement getLoggedInUser
        //return userRepository.getLoggedInUser(user);
        return null;
    }

    public User saveNewUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}