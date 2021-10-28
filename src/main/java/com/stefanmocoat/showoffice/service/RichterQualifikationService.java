package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.RichterQualifikation;
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

    public RichterQualifikation add(RichterQualifikation richterQualifikation) {
        return richterQualifikationRepository.save(richterQualifikation);
    }

    public RichterQualifikation update(RichterQualifikation richterQualifikation) {
        return richterQualifikationRepository.save(richterQualifikation);
    }

    public void delete(RichterQualifikation richterQualifikation) {
        richterQualifikationRepository.delete(richterQualifikation);
    }

    public RichterQualifikation findByName(String name) {
        return richterQualifikationRepository.findByName(name);
    }

}
