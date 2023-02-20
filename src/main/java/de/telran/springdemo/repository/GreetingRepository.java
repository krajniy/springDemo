package de.telran.springdemo.repository;

import de.telran.springdemo.model.Greeting;

import java.util.Optional;

public interface GreetingRepository {

    Optional<Greeting> find(long id);

    long save(Greeting greeting);
}