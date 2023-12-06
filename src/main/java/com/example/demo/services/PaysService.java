package com.example.demo.services;

import com.example.demo.Dto.AddCountryRequest;
import com.example.demo.entities.Country;
import com.example.demo.entities.Pays;

import java.util.List;

public interface PaysService {
    List<Pays> GetPays();


    Pays AddPays(Pays request);
}
