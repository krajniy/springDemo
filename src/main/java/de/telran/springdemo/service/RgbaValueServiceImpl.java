package de.telran.springdemo.service;

import de.telran.springdemo.entity.RgbaValue;
import de.telran.springdemo.repository.RgbaValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class RgbaValueServiceImpl implements RgbaValueService {

    @Autowired
    RgbaValueRepository repository;

    @Override
    public long createOrGet(RgbaValue rgbaValue) {
        return repository.save(rgbaValue).getId();
    }

    @Override
    public RgbaValue get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean existsWithGivenValue(int value) {
        return false;
    }
}
