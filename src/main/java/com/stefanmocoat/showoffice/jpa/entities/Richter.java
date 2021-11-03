package com.stefanmocoat.showoffice.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class Richter extends AbstractEntity {

	@Column
	private String richterId;

	@Column(length = 75)
	private String name;

	@OneToMany(mappedBy = "richter", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RichterQualAssignment> qualAssignments = new ArrayList<>();

	public String getRichterId() {
		return richterId;
	}

	public void setRichterId(String znsRichterId) {
		this.richterId = znsRichterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RichterQualAssignment> getQualAssignments() {
		return qualAssignments;
	}

	public void setQualAssignments(List<RichterQualAssignment> qualAssignments) {
		this.qualAssignments = qualAssignments;
	}
}
