package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Bewerb;

@Repository
public interface BewerbRepository extends JpaRepository<Bewerb, Integer> {

	Bewerb findByName(String name);

}