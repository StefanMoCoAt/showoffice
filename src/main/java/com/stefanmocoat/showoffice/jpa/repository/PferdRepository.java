package com.stefanmocoat.showoffice.jpa.repository;

import com.stefanmocoat.showoffice.jpa.entities.zns.Pferd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PferdRepository extends JpaRepository<Pferd, Long> {

    Pferd findByKopfnummer(String kopfnummer);

    Pferd findByPferdename(String pferdename);

}
