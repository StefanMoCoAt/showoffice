package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.verein.Verein;
import com.stefanmocoat.showoffice.jpa.repository.VereinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VereinService {

    @Autowired
    VereinRepository repository;

    public List<Verein> findAll() {
        return repository.findAll();
    }

    public Verein findOne(long id) {
        return repository.findById(id).orElse(null);
    }

    public Verein findByVereinId(String vereinNr) {
        return repository.findByVereinId(vereinNr);
    }

    public Verein findByVereinName(String vereinName) {
        return repository.findByVereinName(vereinName);
    }

    public Verein add(Verein verein) {
        return repository.save(verein);
    }

    public void update(Verein verein) {
        repository.save(verein);
    }

    public void delete(Verein verein) {
        repository.delete(verein);
    }

}
