package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauer;
import com.stefanmocoat.showoffice.jpa.repository.ParcoursBauerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcoursBauerService {

    @Autowired
    ParcoursBauerRepository repo;

    public List<ParcoursBauer> findAll() {
        return repo.findAll();
    }

    public ParcoursBauer findOne(long id) {
        return repo.findById(id).orElse(null);
    }

    public ParcoursBauer add(ParcoursBauer parcoursBauer) {
        return repo.save(parcoursBauer);
    }

    public void update(ParcoursBauer parcoursBauer) {
        repo.save(parcoursBauer);
    }

    public void delete(ParcoursBauer parcoursBauer) {
        repo.delete(parcoursBauer);
    }

    public ParcoursBauer findByParcoursBauerId(String pacourId) {
        return repo.findByParcousBauerId(pacourId);
    }

}
