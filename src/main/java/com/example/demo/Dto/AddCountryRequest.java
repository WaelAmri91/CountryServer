package com.example.demo.Dto;

import com.example.demo.entities.Pays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryRequest {
    private String title;

    private long population;

    private String location;

    private Long paysId;
}
