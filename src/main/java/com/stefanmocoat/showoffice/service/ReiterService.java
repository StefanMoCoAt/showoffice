package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.Reiter;
import com.stefanmocoat.showoffice.jpa.repository.ReiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReiterService {

    @Autowired
    ReiterRepository reiterRepository;

    public List<Reiter> findAll() {
        return reiterRepository.findAll();
    }

    public Reiter findOne(String satznummer) {
        return reiterRepository.findBySatzNrReiter(satznummer);
    }

    public Reiter findByFamilienname(String name) {
        return reiterRepository.findAllByFamilienname(name);
    }

    public Reiter findByMitgliedsNummer(String mitgliedsNr) {
        return reiterRepository.findByMitgliedsnummer(mitgliedsNr);
    }

    public Reiter add(Reiter reiter) {
        return reiterRepository.save(reiter);
    }

    public void update(Reiter reiter) {
        reiterRepository.save(reiter);
    }

    public void delete(Reiter reiter) {
        reiterRepository.delete(reiter);
    }

}
