package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pays implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paydId ;

    private String title;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="pays")
    private List<Country> countrys;

    public Pays(String title) {
        this.title = title;
    }
}
