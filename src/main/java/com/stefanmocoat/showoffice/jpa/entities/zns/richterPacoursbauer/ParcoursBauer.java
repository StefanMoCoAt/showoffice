package com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.stefanmocoat.showoffice.jpa.entities.AbstractEntity;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem Y-Satz.
 */
@Entity
public class ParcoursBauer extends AbstractEntity {

	@Column
	private String parcousBauerId;

	@Column
	private String name;

	@OneToMany(mappedBy = "parcoursBauer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ParcoursBauerQualAssignment> qualAssignments = new ArrayList<>();

	public String getParcousBauerId() {
		return parcousBauerId;
	}

	public void setParcousBauerId(String znsRichterId) {
		this.parcousBauerId = znsRichterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ParcoursBauerQualAssignment> getQualAssignments() {
		return qualAssignments;
	}

	public void setQualAssignments(List<ParcoursBauerQualAssignment> qualAssignments) {
		this.qualAssignments = qualAssignments;
	}
}
