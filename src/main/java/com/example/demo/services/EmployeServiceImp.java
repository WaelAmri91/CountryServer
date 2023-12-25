package com.example.demo.services;

import com.example.demo.Dto.AddEmployeRequest;
import com.example.demo.entities.Employe;
import com.example.demo.repositories.DepartementRepository;
import com.example.demo.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImp implements EmployeService {
    @Autowired
    EmployeRepository employeRepository;
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Employe> GetEmployes(){return (List<Employe>) employeRepository.findAll();}
    @Override
    public Employe GetEmploye(long employeId){return employeRepository.findById(employeId).orElse(null);}


    @Override
        public Employe AddEmploye (AddEmployeRequest request) {
             Employe employe=new Employe();
                    employe.setTitle(request.getTitle());
             employe.setEmpNum(request.getEmpNum());

            if(request.getDepartementId() != null)
                employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
            return employeRepository.save(employe);
       }
         @Override
        public Employe EditEmploye(long employeId, AddEmployeRequest request) {
            Employe employe=employeRepository.findById(employeId).orElse(null);
                   if(employe != null){
                      employe.setTitle(request.getTitle());
                       employe.setEmpNum(request.getEmpNum());
                        employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
                        if(request.getDepartementId() != null)
                            employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
                        return employeRepository.save(employe);
                   }
                   return null;
        }
    @Override
    public void DeleteEmploye(long employeId) {
        employeRepository.deleteById(employeId);
    }


}
