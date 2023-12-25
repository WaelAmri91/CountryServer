package com.example.demo.services;

import com.example.demo.entities.Departement;

import java.util.List;

public interface DepartementService {
    List<Departement> GetDepartements();
        Departement addDepartement(Departement request);
}
