package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.PferdeFarbe;

@Repository
public interface PferdeFarbeRepository extends JpaRepository<PferdeFarbe, Long> {

	PferdeFarbe findByFarbe(String farbe);

}
