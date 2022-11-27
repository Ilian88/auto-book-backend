package com.example.autobookrest.repository;

import com.example.autobookrest.model.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
