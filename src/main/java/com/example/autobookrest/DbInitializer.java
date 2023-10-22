package com.example.autobookrest;

import com.example.autobookrest.model.entity.CarEntity;
import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.enums.Gender;
import com.example.autobookrest.model.enums.Role;
import com.example.autobookrest.repository.CarRepository;
import com.example.autobookrest.repository.CommentRepository;
import com.example.autobookrest.repository.UserRepository;
import com.example.autobookrest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DbInitializer implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(DbInitializer.class);
    private final UserRepository userRepository;
    private final UserService userService;

    private final CarRepository carRepository;
    private final CommentRepository commentRepository;

    public DbInitializer(UserRepository userRepository, UserService userService, CarRepository carRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.carRepository = carRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public void run() {
        UserEntity user1 = new UserEntity();
        CarEntity carEntity = new CarEntity();
        Comment comment = new Comment();

        if (this.userRepository.count() == 0) {
            user1.setUsername("ilian88")
                    .setEmail("ilian@abv.bg")
                    .setRole(Role.ADMIN)
                    .setGender(Gender.MALE)
                    .setPassword(new BCryptPasswordEncoder().encode("12345"));

            this.userRepository.save(user1);
            logger.debug(String.format("User persisted: %s", user1));
        }

        if (this.carRepository.count() == 0) {
            carEntity.setMake("Mercedes")
                    .setModel("CLK 270")
                    .setDisplacement(2.7)
                    .setFuelConsumtpion(5.5)
                    .setOwner(user1)
                    .setPicURL("https://i.ytimg.com/vi/L6JJMugre_k/hqdefault.jpg")
                    .setDescription("Very good, comfort and economical car. Decent acceleration.")
                    .setComments(Set.of(comment));

            this.carRepository.save(carEntity);
            logger.debug(String.format("Car persisted: %s", carEntity));
        }

        if (this.commentRepository.count() == 0) {

            UserEntity user = this.userService.findUserByUsername("ilian88");

            comment
                    .setText("Some very great car")
                    .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()))
                    .setOwner(user)
                    .setCar(carEntity);

            Comment comment1 = new Comment(comment);
            comment1.setText("I totally agree with you. Is awsome")
                    .setOwner(user)
                    .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

            Comment comment2 = new Comment(comment1);
            comment2.setText("Best car ever")
                    .setOwner(user)
                    .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

            this.commentRepository.saveAll(List.of(comment1, comment, comment2));
            logger.debug(String.format("Comment persisted: %s", comment1));
            logger.debug(String.format("Comment persisted: %s", comment2));
        }
    }
}
