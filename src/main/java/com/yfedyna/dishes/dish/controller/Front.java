package com.yfedyna.dishes.dish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Front {

    @GetMapping("/index")
    public String start(){
        return "index";
    }
}
