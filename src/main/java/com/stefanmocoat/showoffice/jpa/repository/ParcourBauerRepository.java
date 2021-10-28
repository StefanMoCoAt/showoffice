package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcourBauerRepository extends JpaRepository<ParcoursBauer, Long> {

    ParcoursBauer findByZnsId(String znsId);

}