package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.Reiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReiterRepository extends JpaRepository<Reiter, Long> {

    Reiter findByReiterId(long reiterId);

    Reiter findBySatzNrReiter(String satzNrReiter);

    Reiter findByFullName(String fullName);

    Reiter findByMitgliedsnummer(String mitgliedsNr);

}
