package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hi Sanket, Greetings from Spring Boot!";
    }

    @RequestMapping("/coal-mine")
    public String coalMine() {
        return "Tweet";
    }
}