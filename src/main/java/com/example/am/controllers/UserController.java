package com.example.am.controllers;
import com.example.am.models.User;
import com.example.am.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User userLogin){
        List<User> users = userRepository.findAll();
        for (int i=0;i<users.size();i++) {
            if (users.get(i).getEmail().equals(userLogin.getEmail()) && passwordEncoder.matches(userLogin.getPassword(),users.get(i).getPassword())) {
                return users.get(i);
            }
        }
        return null ;
    }
}

