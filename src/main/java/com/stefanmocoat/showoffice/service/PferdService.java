package com.stefanmocoat.showoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.stefanmocoat.showoffice.jpa.entities.Pferd;
import com.stefanmocoat.showoffice.jpa.repository.PferdRepository;

@Service
public class PferdService extends CrudService<Pferd, Integer> {

	@Autowired
	PferdRepository pferdRepository;

	public List<Pferd> findAll() {
		return pferdRepository.findAll();
	}

	public Pferd finOne(int id) {
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

	public void delete(Pferd pferd) {
		pferdRepository.delete(pferd);
	}

	@Override
	protected JpaRepository<Pferd, Integer> getRepository() {
		return pferdRepository;
	}

}
