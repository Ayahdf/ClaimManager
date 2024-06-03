package com.example.gestiondesreclamations.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceControlleur {

    @GetMapping("listservice")
    public String start(){
        return "listservice";
    }
}
