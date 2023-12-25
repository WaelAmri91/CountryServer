package com.example.demo.services;

import com.example.demo.entities.Departement;
import com.example.demo.entities.Team;
import com.example.demo.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImp implements DepartementService{
    @Autowired
    DepartementRepository departementRepository;
    public List<Departement> GetDepartements(){ return (List<Departement>) departementRepository.findAll();}
      @Override
        public  Departement addDepartement(Departement request){
            Departement departement= new Departement(request.getTitle());

            return departementRepository.save(departement);
        }
}
