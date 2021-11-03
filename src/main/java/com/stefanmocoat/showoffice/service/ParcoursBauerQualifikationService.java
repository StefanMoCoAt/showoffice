package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauerQualifikation;
import com.stefanmocoat.showoffice.jpa.repository.ParcoursBauerQualifikationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcoursBauerQualifikationService {

    @Autowired
    ParcoursBauerQualifikationRepository parcoursBauerQualifikationRepository;

    public List<ParcoursBauerQualifikation> findAll() {
        return parcoursBauerQualifikationRepository.findAll();
    }

    public ParcoursBauerQualifikation findOne(long id) {
        return parcoursBauerQualifikationRepository.findById(id).orElse(null);
    }

    public ParcoursBauerQualifikation add(ParcoursBauerQualifikation parcoursBauerQualifikation) {
        return parcoursBauerQualifikationRepository.save(parcoursBauerQualifikation);
    }

    public ParcoursBauerQualifikation update(ParcoursBauerQualifikation parcoursBauerQualifikation) {
        return parcoursBauerQualifikationRepository.save(parcoursBauerQualifikation);
    }

    public void delete(ParcoursBauerQualifikation parcoursBauerQualifikation) {
        parcoursBauerQualifikationRepository.delete(parcoursBauerQualifikation);
    }

    public ParcoursBauerQualifikation findByName(String name) {
        return parcoursBauerQualifikationRepository.findByName(name);
    }

}
