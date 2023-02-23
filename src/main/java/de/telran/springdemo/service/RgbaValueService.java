package de.telran.springdemo.service;

import de.telran.springdemo.entity.RgbaValue;

public interface RgbaValueService {
    long createOrGet(RgbaValue rgbaValue);

    RgbaValue get(long id);

    boolean existsWithGivenValue(int value);
}
