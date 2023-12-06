package com.example.demo.controllers;

import com.example.demo.entities.Pays;
import com.example.demo.services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pays")
public class PaysController {

    @Autowired
    PaysService paysService;

    @GetMapping("/GetPays")
    public List<Pays> GetPays(){
        return paysService.GetPays();
    }

    @PostMapping("/addPays")
    public Pays addPays(@RequestBody Pays pays){
            return paysService.AddPays(pays);
    }
}
