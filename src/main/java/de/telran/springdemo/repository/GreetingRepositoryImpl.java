package de.telran.springdemo.repository;

import de.telran.springdemo.model.Greeting;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    private static final List<Greeting> list = new ArrayList<>();

    @PostConstruct
    public void populateList() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(new Greeting(i + 1, "Hello World " + i, r.nextInt(5)));
        }
    }

    @Override
    public Optional<Greeting> find(long id) {
        Greeting value = null;

        try {
            value = list.get((int) id - 1);
        } catch (Exception ignored) {}

        return Optional.ofNullable(value);
    }

    @Override
    public long save(Greeting greeting) {
        int id = (int) greeting.getId();

        if (id == 0) {
            list.add(greeting);
            return list.size();
        }

        list.set(id, greeting);
        return id;
    }
}
