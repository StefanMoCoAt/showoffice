package com.stefanmocoat.showoffice.service;

import com.stefanmocoat.showoffice.jpa.entities.Richter;
import com.stefanmocoat.showoffice.jpa.repository.RichterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RichterService {

    @Autowired
    RichterRepository richterRepository;

    public List<Richter> findAll() {
        return richterRepository.findAll();
    }

    public Richter findOne(long id) {
        return richterRepository.findById(id).orElse(null);
    }

    public Richter add(Richter richter) {
        return richterRepository.save(richter);
    }

    public void update(Richter richter) {
        richterRepository.save(richter);
    }

    public void delete(Richter richter) {
        richterRepository.delete(richter);
    }

    public Richter findByRichterId(String richterId) {
        return richterRepository.findByRichterId(richterId);
    }

}
