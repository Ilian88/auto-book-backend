package com.example.autobookrest.service;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCars(int pageNo, int pageSize, String sortBy, String sortDir);
    void createCar(CarDTO car, String onwerUsername) throws NoSuchUserException;
    CarDTO getCarById(String id);
    void updateCar(String carId, CarDTO carDTO);

    void deleteCar(String id);
}
