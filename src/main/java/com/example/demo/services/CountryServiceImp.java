package com.example.demo.services;

import com.example.demo.Dto.AddCountryRequest;
import com.example.demo.entities.Country;
import com.example.demo.entities.LocationCountry;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PaysRepository paysRepository;

    @Override
    public List<Country> GetCountrys() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country GetCountry(long countryId) {
        return countryRepository.findById(countryId).orElse(null);
    }

    @Override
    public Country AddCountry(AddCountryRequest request) {
        Country country=new Country();
        country.setTitle(request.getTitle());
        country.setPopulation(request.getPopulation());
       if (Objects.equals(request.getLocation(), "NORTH")){
           country.setLocation(LocationCountry.NORTH);
       }
       if (Objects.equals(request.getLocation(), "SOUTH")){
            country.setLocation(LocationCountry.SOUTH);
       }
       if (Objects.equals(request.getLocation(), "MIDDLE")){
            country.setLocation(LocationCountry.MIDDLE);
       }
       if(request.getPaysId() != null)
           country.setPays(paysRepository.findById(request.getPaysId()).orElse(null));

       return countryRepository.save(country);
    }

    @Override
    public Country EditCountry(long countryId, AddCountryRequest request) {
        Country country=countryRepository.findById(countryId).orElse(null);
        if(country != null){
            country.setTitle(request.getTitle());
            country.setPopulation(request.getPopulation());
            //country.setPays(paysRepository.findById(request.getPaysId()).orElse(null));
            if(request.getPaysId() != null)
                country.setPays(paysRepository.findById(request.getPaysId()).orElse(null));
            return countryRepository.save(country);
        }
        return null;
    }

    @Override
    public void DeleteCountry(long countryId) {
        countryRepository.deleteById(countryId);

    }

    @Override
    public List<Country> SearchCountrys(String word) {
        return countryRepository.searchByTitle(word);
    }

    @Override
    public List<Country> filterCountry(String sortCriteria) {
        return countryRepository.filterCountry(sortCriteria);
    }

}
