package com.example.demo.repositories;

import com.example.demo.entities.Departement;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement,Long> {
}
