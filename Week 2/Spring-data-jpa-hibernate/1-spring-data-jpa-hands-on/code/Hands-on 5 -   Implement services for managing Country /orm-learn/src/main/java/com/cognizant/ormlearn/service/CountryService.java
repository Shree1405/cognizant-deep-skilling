package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.data.domain.Sort;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
public List<Country> getAllCountries() {
    return countryRepository.findAll();
}

@Transactional
public Country getCountry(String code) {
    return countryRepository.findByCode(code);
}
@Transactional
public void addCountry(Country country) {
    countryRepository.save(country);
}
@Transactional
public void updateCountry(Country country) {
    countryRepository.save(country);
}
@Transactional
public void deleteCountry(String code) {
    Country country = countryRepository.findByCode(code);
    if (country != null) {
        countryRepository.delete(country);
    }
}
@Transactional
public List<Country> searchCountry(String name) {
    return countryRepository.findByNameContainingIgnoreCase(name);
}
@Transactional
public List<Country> getAllCountriesSorted() {
    return countryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
}
}