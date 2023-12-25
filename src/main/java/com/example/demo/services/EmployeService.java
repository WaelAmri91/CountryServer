package com.example.demo.services;

import com.example.demo.Dto.AddEmployeRequest;
import com.example.demo.entities.Employe;

import java.util.List;

public interface EmployeService {
     List<Employe> GetEmployes();

       Employe GetEmploye(long employeId);

       Employe AddEmploye(AddEmployeRequest request);

       Employe EditEmploye(long employeId ,AddEmployeRequest request);

        void DeleteEmploye(long employeId);
}
