package com.example.springboot;

import com.example.entity.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hi Sanket, Greetings from Spring Boot!";
    }

    @RequestMapping("/coal-mine")
    public String coalMine() {
        String value = "TWEET";

        return value;
    }

    @RequestMapping("/hello")
    public Person Hello() {
        return new Person("Hello World!");
    }

    @RequestMapping(path = "hello/{name}")
    public Person getHelloName(@PathVariable("name") String name) {
        StringBuilder value = new StringBuilder("Hello ");

        if (name != null) {
            value.append(name);
        }

        return new Person(value.toString());
    }
}