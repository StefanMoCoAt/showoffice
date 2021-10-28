package com.stefanmocoat.showoffice.jpa.entities.zns.pferde;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauer;
import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauerQualifikation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class PferdFarbenAssignment {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JsonIgnore
	private PferdFarbenAssignment pferdFarbenAssignment;

	@ManyToOne
	private PferdFarben pferdFarben;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PferdFarbenAssignment getPferdFarbenAssignment() {
		return pferdFarbenAssignment;
	}

	public void setPferdFarben(PferdFarben pferdFarben) {
		this.pferdFarben = pferdFarben;
	}

	public PferdFarbenAssignment getPferdFarben() {
		return pferdFarbenAssignment;
	}

	public void setQualifikation(PferdFarben pferdFarben) {
		this.pferdFarben = pferdFarben;
	}

}
