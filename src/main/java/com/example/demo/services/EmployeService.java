package com.example.demo.services;

import com.example.demo.Dto.AddEmployeRequest;
import com.example.demo.entities.Employe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeService {
     List<Employe> GetEmployes();

       Employe GetEmploye(long employeId);

       Employe AddEmploye(AddEmployeRequest request);

       Employe EditEmploye(long employeId ,AddEmployeRequest request);

        void DeleteEmploye(long employeId);

    Employe addFile(MultipartFile multipartFile, Long employeId);

    ResponseEntity<byte[]> retrieveFile(Long employeId) throws IOException;
}
