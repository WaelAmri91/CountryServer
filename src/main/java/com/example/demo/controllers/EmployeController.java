package com.example.demo.controllers;

import com.example.demo.Dto.AddEmployeRequest;
import com.example.demo.entities.Employe;
import com.example.demo.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    EmployeService employeService;
     @GetMapping("/GetEmployes")
            public List<Employe> GetEmployes(){
               return employeService.GetEmployes();
        }

            @GetMapping("/GetEmploye/{idEmploye}")
            public Employe GetEmploye(@PathVariable("idEmploye") Long idEmploye ){
               return employeService.GetEmploye(idEmploye);
           }
             @PostMapping("/AddEmploye")
           public Employe AddEmploye(@RequestBody AddEmployeRequest request){
                return employeService.AddEmploye(request);
           }

            @PutMapping("/EditEmploye/{idEmploye}")
            public Employe EditEmploye(@PathVariable("idEmploye") Long idEmploye,@RequestBody AddEmployeRequest request ){
               return employeService.EditEmploye(idEmploye,request);
            }

            @DeleteMapping("/DeleteEmploye/{idEmploye}")
            public void DeleteEmploye(@PathVariable("idEmploye") Long idEmploye ){
                 employeService.DeleteEmploye(idEmploye);
            }

}
