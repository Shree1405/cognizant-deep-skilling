package com.cognizant.spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_rest.Country;
import com.cognizant.spring_rest.exception.CountryNotFoundException;
import com.cognizant.spring_rest.service.CountryService;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() throws CountryNotFoundException {
        return countryService.getCountry("IN");
    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code)
            throws CountryNotFoundException {

        return countryService.getCountry(code);
    }
    
}