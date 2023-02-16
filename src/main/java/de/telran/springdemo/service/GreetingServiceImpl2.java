package de.telran.springdemo.service;

import de.telran.springdemo.model.Greeting;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("test")

public class GreetingServiceImpl2 implements GreetingService {

    @Override
    public long create(Greeting greeting) {
        return Integer.MIN_VALUE;
    }

    @Override
    public Greeting get(long id) {
        return null;
    }

    @Override
    public void update(int id, int count) {

    }
}
