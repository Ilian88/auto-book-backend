package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.CarDTO;
import com.example.autobookrest.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<CarDTO>> getCars(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir
    ) {
        return ResponseEntity
                .ok()
                .body(this.carService.getCars(pageNo, pageSize, sortBy, sortDir));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") String id) {
        CarDTO car = this.carService.getCarById(id);

        return ResponseEntity.ok().body(car);
    }

    @PostMapping("/create")
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO car, Principal principal) {
        this.carService.createCar(car, principal.getName());

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateCar(@PathVariable("id") String carId, @RequestBody @Valid CarDTO carDTO) {
        this.carService.updateCar(carId, carDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") String id) {
        this.carService.deleteCar(id);

        return ResponseEntity.ok().build();
    }
}
