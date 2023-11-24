package com.example.medly_pharma.medly_pharma_web_springboot.Controller;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.User;
import com.example.medly_pharma.medly_pharma_web_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserLRController {
    @Autowired
    private UserService userService;
    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "Registration";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam("role") String[] role) {
        user.setRoles(role); // Set the role based on the selected option in the form
        userService.saveUser(user); // Save the user to the database
        return "redirect:/signin"; // Redirect to the login page after successful registration
    }
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
