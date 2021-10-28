package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauer;
import com.stefanmocoat.showoffice.jpa.repository.ParcourBauerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcourBauerService {

    @Autowired
    ParcourBauerRepository repo;

    public List<ParcoursBauer> findAll() {
        return repo.findAll();
    }

    public ParcoursBauer findOne(long id) {
        return repo.findById(id).orElse(null);
    }

    public ParcoursBauer add(ParcoursBauer ParcoursBauer) {
        return repo.save(ParcoursBauer);
    }

    public void update(ParcoursBauer ParcoursBauer) {
        repo.save(ParcoursBauer);
    }

    public void delete(ParcoursBauer ParcoursBauer) {
        repo.delete(ParcoursBauer);
    }

    public ParcoursBauer findByParcourId(String pacourId) {
        return repo.findByZnsId(pacourId);
    }

}
