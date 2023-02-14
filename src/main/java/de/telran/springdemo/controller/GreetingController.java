package de.telran.springdemo.controller;

import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.service.GreetingService;
import de.telran.springdemo.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    @Autowired
    private GreetingService service;

    @RequestMapping(method = RequestMethod.POST, path = "/greet")
    public int createGreeting(@RequestBody Greeting greeting) {
        return service.create(greeting);
    }

    @GetMapping("/greet/{id}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/greet/{id}")
    public void modifyGreeting(@PathVariable int id, @RequestParam int count) {
        service.update(id, count);
    }
}
