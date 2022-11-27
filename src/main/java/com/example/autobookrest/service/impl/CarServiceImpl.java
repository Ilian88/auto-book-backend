package com.example.autobookrest.service.impl;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.CarDTO;
import com.example.autobookrest.model.entity.CarEntity;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.repository.CarRepository;
import com.example.autobookrest.service.CarService;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public CarServiceImpl(CarRepository carRepository, UserService userService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarDTO> getCars() {
        return this.carRepository.findAll()
                .stream()
                .map(car ->{
                     CarDTO carDTO = this.modelMapper.map(car, CarDTO.class);
                     carDTO.setOwner(car.getOwner().getUsername());
                     return carDTO;
                    })
                .collect(Collectors.toList());
    }

    @Override
    public void createCar(CarDTO car) {
        UserEntity owner;
        CarEntity carEntity = modelMapper.map(car, CarEntity.class);
        try {
            owner = this.userService.findUserByUsername(car.getOwner());
        } catch (NoSuchUserException ex) {
            throw new NoSuchUserException("There is no such user");
        }

        carEntity.setOwner(owner);

        this.carRepository.save(carEntity);
    }
}