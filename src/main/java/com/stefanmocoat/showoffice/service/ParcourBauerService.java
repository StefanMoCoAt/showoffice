package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.ParcourBauer;
import com.stefanmocoat.showoffice.jpa.repository.ParcourBauerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcourBauerService {

    @Autowired
    ParcourBauerRepository repo;

    public List<ParcourBauer> findAll() {
        return repo.findAll();
    }

    public ParcourBauer findOne(long id) {
        return repo.findById(id).orElse(null);
    }

    public ParcourBauer add(ParcourBauer ParcourBauer) {
        return repo.save(ParcourBauer);
    }

    public void update(ParcourBauer ParcourBauer) {
        repo.save(ParcourBauer);
    }

    public void delete(ParcourBauer ParcourBauer) {
        repo.delete(ParcourBauer);
    }

    public ParcourBauer findByParcourId(String pacourId) {
        return repo.findByZnsId(pacourId);
    }

}
