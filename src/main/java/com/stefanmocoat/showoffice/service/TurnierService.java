package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.TURIERBEZEICHNUNG;
import com.stefanmocoat.showoffice.jpa.repository.TurnierRepository;

@Component
public class TurnierService {

	@Autowired
	TurnierRepository repo;

	public List<TURIERBEZEICHNUNG> findAll() {
		return repo.findAll();
	}

	public TURIERBEZEICHNUNG findOne(Integer turnierId) {
		return repo.findById(turnierId).orElse(null);
	}

	public TURIERBEZEICHNUNG add(TURIERBEZEICHNUNG Turnier) {
		return repo.save(Turnier);
	}

	public TURIERBEZEICHNUNG update(TURIERBEZEICHNUNG Turnier) {
		return repo.save(Turnier);
	}

	public void delete(TURIERBEZEICHNUNG Turnier) {
		repo.delete(Turnier);
	}

	public TURIERBEZEICHNUNG findByName(String name) {
		return repo.findByName(name);
	}

}
