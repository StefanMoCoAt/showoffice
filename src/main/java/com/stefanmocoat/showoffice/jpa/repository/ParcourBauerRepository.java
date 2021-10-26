package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.ParcourBauer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcourBauerRepository extends JpaRepository<ParcourBauer, Long> {

    ParcourBauer findByZnsId(String znsId);

}