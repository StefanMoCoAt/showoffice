package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.RichterQualifikation;
import com.stefanmocoat.showoffice.jpa.repository.RichterQualifikationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RichterQualifikationService {

    @Autowired
    RichterQualifikationRepository richterQualifikationRepository;

    public List<RichterQualifikation> findAll() {
        return richterQualifikationRepository.findAll();
    }

    public RichterQualifikation findOne(long id) {
        return richterQualifikationRepository.findById(id).orElse(null);
    }

    public RichterQualifikation add(RichterQualifikation RichterQualifikation) {
        return richterQualifikationRepository.save(RichterQualifikation);
    }

    public RichterQualifikation update(RichterQualifikation RichterQualifikation) {
        return richterQualifikationRepository.save(RichterQualifikation);
    }

    public void delete(RichterQualifikation RichterQualifikation) {
        richterQualifikationRepository.delete(RichterQualifikation);
    }

    public RichterQualifikation findByName(String name) {
        return richterQualifikationRepository.findByName(name);
    }

}
