package com.geekbrains.july.market.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class MainController {
    @GetMapping("/unsecured")
    public String usecuredPage() {
        return "unsecured";
    }

    @GetMapping("/")
    public String homePage(HttpServletRequest httpServletRequest) {
        return "home";
    }



    @GetMapping("/authenticated")
    public String authenticatedPage(Principal principal) {
        
//        Authentication a = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(Thread.currentThread().getName());
        String out = String.format("authenticated user: %s, password: %s", principal.getName(), "-");
        return out;
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
