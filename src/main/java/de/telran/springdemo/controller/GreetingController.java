package de.telran.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    //post get put patch delete

    private static String greetValue = "world";

    @GetMapping("/greet")
    public String greet(){
        return "Hello " + greetValue;
    }

    @GetMapping("/setgreet/{val}")
    public void setGreetValue(@PathVariable("val") String value){
        greetValue = value;
    }
}
