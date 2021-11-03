
package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.Turnier;
import com.stefanmocoat.showoffice.jpa.repository.TurnierRepository;

@Component
public class TurnierService {

	@Autowired
	TurnierRepository repo;

	public List<Turnier> findAll() {
		return repo.findAll();
	}

	public Turnier findOne(Long turnierId) {
		return repo.findById(turnierId).orElse(null);
	}

	public Turnier add(Turnier Turnier) {
		return repo.save(Turnier);
	}

	public Turnier update(Turnier Turnier) {
		return repo.save(Turnier);
	}

	public void delete(Turnier Turnier) {
		repo.delete(Turnier);
	}

	public Turnier findByNumber(String number) {
		return repo.findByNumber(number);
	}

}
