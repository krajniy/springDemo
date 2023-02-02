package de.telran.springdemo.controller;

import de.telran.springdemo.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    //POST GET PUT PATCH DELETE

    private static final List<Greeting> list = new ArrayList<>();

    @PostMapping("/creategreeting")
    public int createGreeting(@RequestBody Greeting greeting) {
        list.add(greeting);
        return list.size() - 1;
    }


    @GetMapping("/greet/{id}")
    public String greet(@PathVariable int id) {
        Greeting g = list.get(id);

        return ("Hello " + g.getValue().repeat(g.getCount()));
    }

    @PatchMapping("/greet/{id}")
    public void modifyGreeting(@PathVariable int id, @RequestParam int count) {
        list.get(id).setCount(count);
    }


    @GetMapping("/greeteveryone")
    public String greet() {
        return "Hello world";
    }

    @GetMapping("/greetsomeone/{val}") // .../greetsomeone/world
    public String greetSomeone1(@PathVariable("val") String value) {
        return "Hello " + value.repeat(2);
    }

    @GetMapping("/greetsomeone/{val1}/{val2}") // .../greetsomeone/world
    public String doubleGreet(
            @PathVariable("val1") String value1,
            @PathVariable("val2") String value2) {
        return "Hello " + value1 + " " + value2;
    }

    @GetMapping("/greetsomeone/{val1}/{val2}/params") // .../greetsomeone/test/world/params?count=2

    public String doubleGreetWithParams(
            @PathVariable("val1") String value1,
            @PathVariable("val2") String value2,
            @RequestParam("count") int count) {
        return ("Hello " + value1 + " " + value2 + "<br>").repeat(count);
    }


    @GetMapping("/greetsomeone") // .../greetsomeone?val=spring
    public String greetSomeone2(@RequestParam("val") String value) {
        return "REQUEST PARAM: Hello " + value;
    }
}
