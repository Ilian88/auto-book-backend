package com.example.autobookrest.service.impl;

import com.example.autobookrest.exception.NoSuchUserException;
import com.example.autobookrest.model.dto.CarDTO;
import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.entity.CarEntity;
import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.repository.CarRepository;
import com.example.autobookrest.service.CarService;
import com.example.autobookrest.service.CommentService;
import com.example.autobookrest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserService userService;

    private final CommentService commentService;
    private final ModelMapper modelMapper;


    public CarServiceImpl(CarRepository carRepository, UserService userService, CommentService commentService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.userService = userService;
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarDTO> getCars() {
        return this.carRepository.findAll()
                .stream()
                .map(car ->{
                     CarDTO carDTO = this.modelMapper.map(car, CarDTO.class);
                     carDTO.setOwner(car.getOwner().getUsername());

//                     Set<CommentDTO> comment = commentService.getCommentByCarId(car.getId());
//                     carDTO.setComments(comment);

                     return carDTO;
                    })
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO getCarById(String id) {
        CarEntity car = this.carRepository.findById(Long.parseLong(id)).orElseThrow();

        CarDTO carDTO =  modelMapper.map(car, CarDTO.class);
        carDTO.setOwner(car.getOwner().getUsername());

        return carDTO;
    }

    @Override
    public void createCar(CarDTO car, String ownerUsername) {
        UserEntity owner;
        CarEntity carEntity = modelMapper.map(car, CarEntity.class);
        try {
            owner = this.userService.findUserByUsername(ownerUsername);
        } catch (NoSuchUserException ex) {
            throw new NoSuchUserException("There is no such user");
        }
        carEntity.setOwner(owner);

        this.carRepository.save(carEntity);
    }

    @Override
    public void updateCar(String carId, CarDTO carDTO) {
        CarEntity car = this.carRepository.findById(Long.parseLong(carId)).orElseThrow();
        updateCarFields(car, carDTO);

        this.carRepository.save(car);
    }

    @Override
    public void deleteCar(String id) {
        this.carRepository.delete(
                this.carRepository.findById(Long.parseLong(id)).orElseThrow()
        );
    }

    private void updateCarFields(CarEntity car, CarDTO carDTO) {
         car
                .setMake(carDTO.getMake())
                .setModel(carDTO.getModel())
                .setDescription(carDTO.getDescription())
                .setEngine(carDTO.getEngine())
                .setFuelConsumtpion(carDTO.getFuelConsumtpion())
                .setPicURL(carDTO.getPicURL());
    }
}
