package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.PferdAbstammung;
import com.stefanmocoat.showoffice.jpa.entities.PferdeFarbe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PferdAbstammungRepository extends JpaRepository<PferdAbstammung, Long> {

	PferdAbstammung findByRasse(String rasse);

}
