package com.example.demo.repositories;

import com.example.demo.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country,Long> {
    @Query(value = "SELECT * FROM Country c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :word, '%'))", nativeQuery = true)
    List<Country> searchByTitle(@Param("word") String word);

    @Query("SELECT c FROM Country c " +
            "WHERE ((:sortCriteria = 'NORTH' AND c.location = 'NORTH') OR " +
            "(:sortCriteria = 'SOUTH' AND c.location = 'SOUTH') OR " +
            "(:sortCriteria = 'MIDDLE' AND c.location = 'MIDDLE')) " +
            "ORDER BY " +
            "c.population DESC")
    List<Country> filterCountry(String sortCriteria);

}
