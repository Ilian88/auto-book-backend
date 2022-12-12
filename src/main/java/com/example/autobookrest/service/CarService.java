package com.example.autobookrest.service;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCars();
    void createCar(CarDTO car) throws NoSuchUserException;
    CarDTO getCarById(String id);
}
