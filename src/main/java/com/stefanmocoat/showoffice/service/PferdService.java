package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.Pferd;
import com.stefanmocoat.showoffice.jpa.repository.PferdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class PferdService {

    @Autowired
    PferdRepository pferdRepository;

    public List<Pferd> findAll() {
        return pferdRepository.findAll();
    }

    public Pferd finOne(long id) {
        return pferdRepository.findById(id).orElse(null);
    }

    public Pferd findByKopfnummer(String kopfnummer) {
        return pferdRepository.findByKopfnummer(kopfnummer);
    }

    public Pferd findByPferdename(String pferdename) {
        return pferdRepository.findByPferdename(pferdename);
    }

    public Pferd add(Pferd pferd) {
        return pferdRepository.save(pferd);
    }

    public void update(Pferd pferd) {
        pferdRepository.save(pferd);
    }

    public void delete(Pferd pferd) {
        pferdRepository.delete(pferd);
    }

}
