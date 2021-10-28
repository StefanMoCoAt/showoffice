package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.RichterQualifikation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RichterQualifikationRepository extends JpaRepository<RichterQualifikation, Long> {

    RichterQualifikation findByName(String name);

}