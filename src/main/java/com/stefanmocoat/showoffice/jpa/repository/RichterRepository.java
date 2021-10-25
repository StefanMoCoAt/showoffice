package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Bewerb;
import com.stefanmocoat.showoffice.jpa.entities.zns.Richter;

@Repository
public interface RichterRepository extends JpaRepository<Richter, Long> {

	Richter findByZnsId(String znsId);
}