package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanmocoat.showoffice.jpa.entities.Reiter;

public interface ReiterRepository extends JpaRepository<Reiter, Long> {

    Reiter findBySatzNrReiter(String satzNrReiter);

    Reiter findAllByFamilienname(String reiterFamilienname);

    Reiter findByMitgliedsnummer(String mitgliedsNr);

}
