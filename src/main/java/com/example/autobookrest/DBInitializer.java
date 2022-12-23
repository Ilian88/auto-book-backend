package com.example.autobookrest;

import com.example.autobookrest.model.entity.CarEntity;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.enums.Gender;
import com.example.autobookrest.model.enums.Role;
import com.example.autobookrest.repository.CarRepository;
import com.example.autobookrest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public DBInitializer(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity();
        if(this.userRepository.count() == 0) {
            user1.setUsername("ilian88")
                    .setEmail("ilian@abv.bg")
                    .setRole(Role.ADMIN)
                    .setGender(Gender.MALE)
                    .setPassword(new BCryptPasswordEncoder().encode("12345"));

            this.userRepository.save(user1);
        }

        if (this.carRepository.count() == 0){
            CarEntity carEntity = new CarEntity();
            carEntity.setMake("Mercedes")
                    .setModel("CLK 270")
                    .setDisplacement(2.7)
                    .setFuelConsumtpion(5.5)
                    .setOwner(user1)
                    .setPicURL("https://i.ytimg.com/vi/L6JJMugre_k/hqdefault.jpg")
                    .setDescription("Very good, comfort and economical car. Decent acceleration.");

            this.carRepository.save(carEntity);
        }
    }
}
