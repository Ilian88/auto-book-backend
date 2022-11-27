package com.example.autobookrest.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
