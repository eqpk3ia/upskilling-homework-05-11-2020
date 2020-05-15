package com.example.springboot;

import com.example.entity.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hi Sanket, Greetings from Spring Boot!";
    }

    @GetMapping("/coal-mine")
    public String coalMine() {
        String value = "TWEET";

        return value;
    }

    @GetMapping("/hello")
    public Person Hello() {
        return new Person("Hello World!");
    }

    @GetMapping(path = "hello/{name}")
    public Person getHelloName(@PathVariable("name") String name) {
        StringBuilder value = new StringBuilder("Hello ");

        if (name != null) {
            value.append(name);
        }

        return new Person(value.toString());
    }
}