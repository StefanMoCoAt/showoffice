package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauerQualifikation;

@Repository
public interface ParcoursBauerQualifikationRepository extends JpaRepository<ParcoursBauerQualifikation, Long> {

    ParcoursBauerQualifikation findByName(String name);

}