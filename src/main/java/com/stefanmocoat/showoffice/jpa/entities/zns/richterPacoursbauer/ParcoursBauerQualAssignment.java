package com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class ParcoursBauerQualAssignment {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JsonIgnore
	private ParcoursBauer parcoursBauer;

	@ManyToOne
	private ParcoursBauerQualifikation qualifikation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ParcoursBauer getParcoursBauer() {
		return parcoursBauer;
	}

	public void setParcoursBauer(ParcoursBauer parcoursBauer) {
		this.parcoursBauer = parcoursBauer;
	}

	public ParcoursBauerQualifikation getQualifikation() {
		return qualifikation;
	}

	public void setQualifikation(ParcoursBauerQualifikation qualifikation) {
		this.qualifikation = qualifikation;
	}

}
