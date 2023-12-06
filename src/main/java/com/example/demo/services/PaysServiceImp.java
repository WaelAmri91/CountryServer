package com.example.demo.services;

import com.example.demo.entities.Country;
import com.example.demo.entities.Pays;
import com.example.demo.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImp implements PaysService {
    @Autowired
    PaysRepository paysRepository ;

    @Override
    public List<Pays> GetPays() {
        return (List<Pays>) paysRepository.findAll();
    }

    @Override
    public Pays AddPays(Pays request) {
        Pays pays=new Pays(request.getTitle());
        return paysRepository.save(pays) ;
    }
}
