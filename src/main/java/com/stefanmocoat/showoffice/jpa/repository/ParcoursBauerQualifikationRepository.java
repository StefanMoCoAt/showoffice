package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauerQualifikation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcoursBauerQualifikationRepository extends JpaRepository<ParcoursBauerQualifikation, Long> {

    ParcoursBauerQualifikation findByName(String name);

}