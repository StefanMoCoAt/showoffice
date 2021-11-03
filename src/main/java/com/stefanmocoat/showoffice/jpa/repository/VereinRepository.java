package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Verein;

@Repository
public interface VereinRepository extends JpaRepository<Verein, Long> {

    Verein findByVereinId(String vereinId);

    Verein findByVereinName(String vereinName);

}
