package com.example.autobookrest.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity{

    private String make;
    private String model;
    private String engine;
    private double displacement;
    private double fuelConsumtpion;
    private String picURL;
    private String description;
    private UserEntity owner;

    public CarEntity() {
    }

    @Column(name = "make", nullable = false)
    @Size(max = 10)
    public String getMake() {
        return make;
    }

    public CarEntity setMake(String make) {
        this.make = make;
        return this;
    }

    @Column(name = "model", nullable = false)
    @Size(max = 15)
    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    @Column(name = "engine_type")
    @Size(max = 10)
    public String getEngine() {
        return engine;
    }

    public CarEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }
    @Column(name = "engine_displacement")
    @Min(1)
    public double getDisplacement() {
        return displacement;
    }

    public CarEntity setDisplacement(double displacement) {
        this.displacement = displacement;
        return this;
    }

    @Column(name = "fuel_consumption")
    @Min(0)
    public double getFuelConsumtpion() {
        return fuelConsumtpion;
    }

    public CarEntity setFuelConsumtpion(double fuelConsumtpion) {
        this.fuelConsumtpion = fuelConsumtpion;
        return this;
    }

    @Column(name = "pic_url",nullable = false)
    @Size(max = 100)
    public String getPicURL() {
        return picURL;
    }

    public CarEntity setPicURL(String picURL) {
        this.picURL = picURL;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    @Size(min = 10, max = 500)
    public String getDescription() {
        return description;
    }

    public CarEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToOne(targetEntity = UserEntity.class)
    public UserEntity getOwner() {
        return owner;
    }

    public CarEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }
}
