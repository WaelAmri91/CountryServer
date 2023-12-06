package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId ;

    private String title;

    private long population;
    @Enumerated(EnumType.STRING)
    private LocationCountry location;


    @ManyToOne
    private Pays pays;

}
