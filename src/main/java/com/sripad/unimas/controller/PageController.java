package com.sripad.unimas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/studentpage")
    public String studentPage(){
        return "index.html";
    }

    @GetMapping("/studentprofile")
    public String studentProfile(){
        return "studentprofile.html";
    }
}
