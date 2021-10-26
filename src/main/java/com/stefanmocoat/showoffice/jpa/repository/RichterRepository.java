package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.Richter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RichterRepository extends JpaRepository<Richter, Long> {

    Richter findByRichterId(String richterId);

}