package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauer;

@Repository
public interface ParcoursBauerRepository extends JpaRepository<ParcoursBauer, Long> {

    ParcoursBauer findByParcousBauerId(String parcousBauerId);

}