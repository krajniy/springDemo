package de.telran.springdemo.service;

import de.telran.springdemo.entity.Color;
import de.telran.springdemo.entity.RgbaValue;
import de.telran.springdemo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@SuppressWarnings("unused")
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository repository;

    @Autowired
    RgbaValueService rgbaValueService;

    @Override
    public long createOrGet(Color color) {
        long rgbaValueId = rgbaValueService.createOrGet(color.getRgbaValue());
        RgbaValue rgbaValue = rgbaValueService.get(rgbaValueId);
        color.setRgbaValue(rgbaValue);

        return repository.save(color).getId();
    }

    @Override
    public Color get(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean existsWithGivenValue(int value) {
        return false;
    }
}
