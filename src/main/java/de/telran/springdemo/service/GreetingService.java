package de.telran.springdemo.service;

import de.telran.springdemo.model.Greeting;

public interface GreetingService {
    long create( Greeting greeting);

    Greeting get(long id);

    void update(int id, int count);
}
