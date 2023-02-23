package de.telran.springdemo.repository;

import de.telran.springdemo.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

//    Optional<Greeting> find(long id);
//
//    long save(Greeting greeting);


}