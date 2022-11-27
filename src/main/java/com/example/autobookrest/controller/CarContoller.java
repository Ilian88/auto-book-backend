package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.CarDTO;
import com.example.autobookrest.service.CarService;
import org.hibernate.annotations.Fetch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cars")
public class CarContoller {
    private final CarService carService;

    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<CarDTO>> getCars() {
        return ResponseEntity
                .ok()
                .body(this.carService.getCars());
    }

    @PostMapping("/create")
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO car) {
        this.carService.createCar(car);
        
       return ResponseEntity.ok().build();
    }
}
