package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.zns.RichterQualifikation;
import com.stefanmocoat.showoffice.jpa.repository.RichterQualifikationRepository;

@Component
public class RichterQualifikationService {

	@Autowired
	RichterQualifikationRepository repo;

	public List<RichterQualifikation> findAll() {
		return repo.findAll();
	}

	public RichterQualifikation findOne(long id) {
		return repo.findById(id).orElse(null);
	}

	public RichterQualifikation add(RichterQualifikation RichterQualifikation) {
		return repo.save(RichterQualifikation);
	}

	public RichterQualifikation update(RichterQualifikation RichterQualifikation) {
		return repo.save(RichterQualifikation);
	}

	public void delete(RichterQualifikation RichterQualifikation) {
		repo.delete(RichterQualifikation);
	}

	public RichterQualifikation findByName(String name) {
		return repo.findByName(name);
	}

}
