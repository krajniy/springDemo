package de.telran.springdemo.service;

import de.telran.springdemo.entity.Color;

public interface ColorService {
    long createOrGet(Color color);

    Color get(long id);

    boolean existsWithGivenValue(int value);
}
