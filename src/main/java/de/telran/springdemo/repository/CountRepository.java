package de.telran.springdemo.repository;

import de.telran.springdemo.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountRepository extends JpaRepository<Counter, Long> {

    boolean existsCounterByCount(int count);

    List<Counter> findByCount(int count);
}