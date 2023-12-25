package com.example.demo.controllers;

import com.example.demo.entities.Departement;
import com.example.demo.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    DepartementService departementService;

     @GetMapping("/getDepartement")
        public List<Departement> GetDepartements(){
            return departementService.GetDepartements();}

        @PostMapping("/addDepartement")
        public Departement addTeam(@RequestBody Departement team){
            return departementService.addDepartement(team);
        }
}
