package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.Verein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VereinRepository extends JpaRepository<Verein, Long> {

    Verein findByVereinId(String vereinId);

    Verein findByVereinName(String vereinName);

}
