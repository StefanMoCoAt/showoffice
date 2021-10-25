package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.ParcourBauer;

@Repository
public interface ParcourBauerRepository extends JpaRepository<ParcourBauer, Long> {

	ParcourBauer findByZnsId(String znsId);
	
}