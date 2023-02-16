package de.telran.springdemo.service;

import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("prod")
//@Primary
@SuppressWarnings("unused")
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository repository;


    public long create(Greeting greeting) {
        return repository.save(greeting);
    }

    public Greeting get(long id) {
        return repository.find(id).orElseThrow(IllegalArgumentException::new);
    }

    public void update(int id, int count) {
        Greeting g = repository.find(id).orElseThrow(IllegalArgumentException::new);
        g.setCount(count);
    }
}