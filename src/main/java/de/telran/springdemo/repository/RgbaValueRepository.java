package de.telran.springdemo.repository;

import de.telran.springdemo.entity.Color;
import de.telran.springdemo.entity.Counter;
import de.telran.springdemo.entity.RgbaValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SuppressWarnings("unused")
public interface RgbaValueRepository extends JpaRepository<RgbaValue, Long> {
}
