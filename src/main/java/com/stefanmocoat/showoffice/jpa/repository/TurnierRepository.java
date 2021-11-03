
package com.stefanmocoat.showoffice.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanmocoat.showoffice.jpa.entities.Turnier;

@Repository
public interface TurnierRepository extends JpaRepository<Turnier, Long> {

	Turnier findByNumber(String number);

}
