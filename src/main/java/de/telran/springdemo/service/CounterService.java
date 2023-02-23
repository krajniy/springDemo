package de.telran.springdemo.service;

import de.telran.springdemo.entity.Counter;

public interface CounterService {
    long createOrGet(Counter counter);

    Counter get(long id);

    boolean existsWithGivenValue(int value);

}
