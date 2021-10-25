package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.zns.ParcourBauer;
import com.stefanmocoat.showoffice.jpa.repository.ParcourBauerRepository;

@Component
public class ParcourBauerService {

	@Autowired
	ParcourBauerRepository repo;

	public List<ParcourBauer> findAll() {
		return repo.findAll();
	}

	public ParcourBauer findOne(long id) {
		return repo.findById(id).orElse(null);
	}

	public ParcourBauer add(ParcourBauer ParcourBauer) {
		return repo.save(ParcourBauer);
	}

	public ParcourBauer update(ParcourBauer ParcourBauer) {
		return repo.save(ParcourBauer);
	}

	public void delete(ParcourBauer ParcourBauer) {
		repo.delete(ParcourBauer);
	}

	public ParcourBauer findByZnsId(String znsId) {
		return repo.findByZnsId(znsId);
	}

}
