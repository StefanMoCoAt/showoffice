package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.Turnier;

@Repository
public interface TurnierRepository extends JpaRepository<Turnier, Integer> {

//	Turnier findByName(String name);

}