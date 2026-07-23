package com.cognizant.country_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.country_service.model.Country;

import jakarta.validation.Valid;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {

        LOGGER.info("Start");
        LOGGER.info("Country : {}", country);

        return country;
    }
}