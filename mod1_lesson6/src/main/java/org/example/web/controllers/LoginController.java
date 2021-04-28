package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.example.app.services.UserService;
import org.example.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = Logger.getLogger(LoginController.class);
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login(@ModelAttribute("loginForm") User loginForm) {
        logger.info("GET /login returns login_page.html");
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(User loginFrom) {
        if (userService.authenticate(loginFrom)) {
            logger.info("login OK redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("login FAIL redirect back to login");
            return "redirect:/login";
        }
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registerForm") @Valid User registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
                return "/register";

        if (userService.register(registerForm)) {
            logger.info("POST /register register new user. Returns login_page.html");
            return "redirect:/login";
        }else
        {
            logger.info("register FAIL redirect back to register");
            return "redirect:/login/register";
        }
    }
    @GetMapping("/register")
    public String register(Model model)
    {
        logger.info("GET /register returns register.html");
        model.addAttribute("registerForm", new User());
        return "/register";
    }
}
