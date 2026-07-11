package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        OrmLearnApplication app = context.getBean(OrmLearnApplication.class);

        app.testSearchCountries();

        app.testSearchCountriesSorted();

        app.testCountriesStartingWith();

        context.close();
    }

    public void testSearchCountries() {

        System.out.println("Countries containing 'ou'");

        countryService.searchCountries("ou")
                .forEach(System.out::println);
    }

    public void testSearchCountriesSorted() {

        System.out.println("\nCountries containing 'ou' in Ascending Order");

        countryService.searchCountriesSorted("ou")
                .forEach(System.out::println);
    }

    public void testCountriesStartingWith() {

        System.out.println("\nCountries starting with 'Z'");

        countryService.getCountriesStartingWith("Z")
                .forEach(System.out::println);
    }
}