package de.telran.springdemo.controller;

import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.service.GreetingService;
import de.telran.springdemo.service.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("unused")
public class GreetingController {
    @Autowired
//    @Qualifier("test")
    private GreetingService service;

//    @Autowired
//    public GreetingController(GreetingService service) {
//        this.service = service;
//    }

//    @Autowired
//    public void setService(GreetingService service){
//        this.service = service;
//    }

    @PostMapping("/greet")
    public ResponseEntity<Long> createGreeting(@RequestBody Greeting greeting) {
        try {
            return new ResponseEntity<>(service.create(greeting), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity<Void> modifyGreeting(@PathVariable int id, @RequestParam int count) {
        try {
            service.update(id, count);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
