package com.example.demo.repositories;

import com.example.demo.entities.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe,Long> {
}
