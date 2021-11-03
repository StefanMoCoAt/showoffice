package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.pferd.PferdeFarbe;
import com.stefanmocoat.showoffice.jpa.repository.PferdRepository;
import com.stefanmocoat.showoffice.jpa.repository.PferdeFarbeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PferdeFarbeService {

    @Autowired
    PferdeFarbeRepository repo;

    public List<PferdeFarbe> findAll() {
        return repo.findAll();
    }

    public PferdeFarbe finOne(long id) {
        return repo.findById(id).orElse(null);
    }

    public PferdeFarbe findByFarbe(String farbe) {
        return repo.findByFarbe(farbe);
    }

    public PferdeFarbe add(PferdeFarbe pferd) {
        return repo.save(pferd);
    }

    public void update(PferdeFarbe pferd) {
        repo.save(pferd);
    }

    public void delete(PferdeFarbe pferd) {
        repo.delete(pferd);
    }

}
