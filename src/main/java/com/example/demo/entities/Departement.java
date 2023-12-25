package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departementId ;

    private String title;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private List<Employe> employes;

    public Departement(String title) {
        this.title = title;
    }
}
