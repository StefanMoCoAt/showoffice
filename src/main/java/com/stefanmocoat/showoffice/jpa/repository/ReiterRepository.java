package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.reiter.Reiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReiterRepository extends JpaRepository<Reiter, Long> {

    Reiter findBySatzNrReiter(String satzNrReiter);

    Reiter findAllByFamilienname(String reiterFamilienname);

    Reiter findByMitgliedsnummer(String mitgliedsNr);

}
