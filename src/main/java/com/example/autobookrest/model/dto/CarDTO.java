package com.example.autobookrest.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CarDTO {
    private long id;
    private String make;
    private String model;
    private String engine;
    private double displacement;
    private double fuelConsumtpion;
    private String picURL;
    private String description;
    private String owner;

    public CarDTO() {
    }

    @Size(max = 10, message = "Make must be max 10 symbols")
    @NotBlank
    public String getMake() {
        return make;
    }

    public CarDTO setMake(String make) {
        this.make = make;
        return this;
    }

    @Size(max = 15, message = "Model must be max 15 symbols")
    @NotBlank
    public String getModel() {
        return model;
    }

    public CarDTO setModel(String model) {
        this.model = model;
        return this;
    }

    @Size(max = 10, message = "Engine type must be max 10 symbols")
    public String getEngine() {
        return engine;
    }

    public CarDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Min(1)
    public double getDisplacement() {
        return displacement;
    }

    public CarDTO setDisplacement(double displacement) {
        this.displacement = displacement;
        return this;
    }

    @Min(1)
    public double getFuelConsumtpion() {
        return fuelConsumtpion;
    }

    public CarDTO setFuelConsumtpion(double fuelConsumtpion) {
        this.fuelConsumtpion = fuelConsumtpion;
        return this;
    }

    @Size(max = 100, message = "Url must be max 100 symbols")
    public String getPicURL() {
        return picURL;
    }

    public CarDTO setPicURL(String picURL) {
        this.picURL = picURL;
        return this;
    }

    @Size(min = 10, max = 500, message = "Desciption must be between 10 and 500 symbols")
    public String getDescription() {
        return description;
    }

    public CarDTO setDescription(String description) {
        this.description = description;
        return this;
    }


    public String getOwner() {
        return owner;
    }

    public CarDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public long getId() {
        return id;
    }

    public CarDTO setId(long id) {
        this.id = id;
        return this;
    }
}
