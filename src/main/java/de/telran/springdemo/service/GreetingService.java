package de.telran.springdemo.service;

import de.telran.springdemo.entity.Greeting;

public interface GreetingService {
    long create( Greeting greeting);

    Greeting get(long id);

    void update(long id, int count);
}
