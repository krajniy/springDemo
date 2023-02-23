package de.telran.springdemo.controller;

import de.telran.springdemo.entity.Color;
import de.telran.springdemo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/color")
@SuppressWarnings("unused")
public class ColorController {
    @Autowired
    private ColorService service;

    @PostMapping()
    public ResponseEntity<Long> createGreeting(@RequestBody Color color) {
        try {
            return new ResponseEntity<>(service.createOrGet(color), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getGreeting(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
