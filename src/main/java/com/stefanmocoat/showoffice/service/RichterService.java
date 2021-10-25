package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.zns.Richter;
import com.stefanmocoat.showoffice.jpa.repository.RichterRepository;

@Component
public class RichterService {

	@Autowired
	RichterRepository repo;

	public List<Richter> findAll() {
		return repo.findAll();
	}

	public Richter findOne(long id) {
		return repo.findById(id).orElse(null);
	}

	public Richter add(Richter Richter) {
		return repo.save(Richter);
	}

	public Richter update(Richter Richter) {
		return repo.save(Richter);
	}

	public void delete(Richter Richter) {
		repo.delete(Richter);
	}

	public Richter findByZnsId(String znsId) {
		return repo.findByZnsId(znsId);
	}

}
