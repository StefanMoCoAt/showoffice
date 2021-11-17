package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.PferdAbstammung;
import com.stefanmocoat.showoffice.jpa.entities.PferdeFarbe;
import com.stefanmocoat.showoffice.jpa.repository.PferdAbstammungRepository;
import com.stefanmocoat.showoffice.jpa.repository.PferdeFarbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PferdAbstammungService {

    @Autowired
    PferdAbstammungRepository repo;

    public List<PferdAbstammung> findAll() {
        return repo.findAll();
    }

    public PferdAbstammung finOne(long id) {
        return repo.findById(id).orElse(null);
    }

    public PferdAbstammung findByRasse(String rasse) {
        return repo.findByRasse(rasse);
    }

    public PferdAbstammung add(PferdAbstammung pferd) {
        return repo.save(pferd);
    }

    public void update(PferdAbstammung pferd) {
        repo.save(pferd);
    }

    public void delete(PferdAbstammung pferd) {
        repo.delete(pferd);
    }

}
