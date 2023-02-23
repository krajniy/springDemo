package de.telran.springdemo.controller;

import de.telran.springdemo.entity.Counter;
import de.telran.springdemo.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/count")
@SuppressWarnings("unused")
public class CountController {
    @Autowired
    private CounterService service;

    @PostMapping()
    public ResponseEntity<Long> createGreeting(@RequestBody Counter counter) {
        try {
            return new ResponseEntity<>(service.createOrGet(counter), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Counter> getGreeting(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}