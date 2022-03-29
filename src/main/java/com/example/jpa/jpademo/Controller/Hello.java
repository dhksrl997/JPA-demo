package com.example.jpa.jpademo.Controller;
/*
Created on 2022/03/29 7:52 PM In Intelli J IDEA 
by jeon-wangi
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/hello")
public class Hello {
    @GetMapping("/index")
    public String hello(Model model) {
        model.addAttribute("data", "sadsadsadsadas " + UUID.randomUUID());
        return "index";
    }
}
