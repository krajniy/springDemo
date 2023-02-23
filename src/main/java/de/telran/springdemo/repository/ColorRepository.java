package de.telran.springdemo.repository;

import de.telran.springdemo.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface ColorRepository extends JpaRepository<Color, Long> {
}
