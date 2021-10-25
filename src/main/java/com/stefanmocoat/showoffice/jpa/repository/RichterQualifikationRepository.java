package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Bewerb;
import com.stefanmocoat.showoffice.jpa.entities.zns.RichterQualifikation;

@Repository
public interface RichterQualifikationRepository extends JpaRepository<RichterQualifikation, Long> {

	RichterQualifikation findByName(String name);

}