package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Pferd;

@Repository
public interface PferdRepository extends JpaRepository<Pferd, Integer> {

    Pferd findByKopfnummer(String kopfnummer);

    Pferd findByPferdename(String pferdename);

}
