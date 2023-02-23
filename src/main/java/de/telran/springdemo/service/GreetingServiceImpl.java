package de.telran.springdemo.service;

import de.telran.springdemo.entity.Counter;
import de.telran.springdemo.entity.Greeting;
import de.telran.springdemo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("prod")
//@Primary
@SuppressWarnings("unused")
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private GreetingRepository repository;

    @Autowired
    private CounterService counterService;

    public long create(Greeting greeting) {
        long counterId = counterService.createOrGet(greeting.getCounter());
        Counter c = counterService.get(counterId);
        greeting.setCounter(c);

        return repository.save(greeting).getId();
    }

    public Greeting get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void update(long id, int count) {
        Greeting g = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        g.setCounter(null);
    }
}