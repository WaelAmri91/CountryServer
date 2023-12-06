package com.example.demo.services;

import com.example.demo.Dto.AddCountryRequest;
import com.example.demo.entities.Country;

import java.util.List;

public interface CountryService {
    List<Country> GetCountrys();

    Country GetCountry(long countryId);

    Country AddCountry(AddCountryRequest request);

    Country EditCountry(long countryId ,AddCountryRequest request);

    void DeleteCountry(long countryId);

    List<Country> SearchCountrys(String word);
    List<Country> filterCountry(String sortCriteria);



}
