package com.example.demo.controllers;

import com.example.demo.Dto.AddCountryRequest;
import com.example.demo.entities.Country;
import com.example.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/GetCountrys")
    public List<Country> GetCountrys(){
        return countryService.GetCountrys();
    }

    @GetMapping("/GetCountry/{idCountry}")
    public Country GetCountry(@PathVariable("idCountry") Long idCountry ){
        return countryService.GetCountry(idCountry);
    }

    @GetMapping("/SearchCountrys/{word}")
    public List<Country> SearchCountrys(@PathVariable("word") String word ){
        return countryService.SearchCountrys(word);
    }

    @GetMapping("/filterCountry/{sortCriteria}")
    public List<Country> filterCountry(@PathVariable("sortCriteria") String sortCriteria ){
        return countryService.filterCountry(sortCriteria);
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody AddCountryRequest request){
        return countryService.AddCountry(request);
    }

    @PutMapping("/EditCountry/{idCountry}")
    public Country EditCountry(@PathVariable("idCountry") Long idCountry,@RequestBody AddCountryRequest request ){
        return countryService.EditCountry(idCountry,request);
    }

    @DeleteMapping("/DeleteCountry/{idCountry}")
    public void DeleteCountry(@PathVariable("idCountry") Long idCountry ){
         countryService.DeleteCountry(idCountry);
    }



}
