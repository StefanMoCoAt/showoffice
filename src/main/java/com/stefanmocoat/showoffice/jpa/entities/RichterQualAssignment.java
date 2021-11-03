package com.stefanmocoat.showoffice.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class RichterQualAssignment {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JsonIgnore
	private Richter richter;

	@ManyToOne
	private RichterQualifikation qualifikation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Richter getRichter() {
		return richter;
	}

	public void setRichter(Richter richter) {
		this.richter = richter;
	}

	public RichterQualifikation getQualifikation() {
		return qualifikation;
	}

	public void setQualifikation(RichterQualifikation qualifikation) {
		this.qualifikation = qualifikation;
	}

}
