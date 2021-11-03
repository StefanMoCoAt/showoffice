package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Paarung extends AbstractEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	private Pferd pferd;

	@ManyToOne(fetch = FetchType.EAGER)
	private Reiter reiter;

	public Pferd getPferd() {
		return pferd;
	}

	public void setPferd(Pferd pferd) {
		this.pferd = pferd;
	}

	public Reiter getReiter() {
		return reiter;
	}

	public void setReiter(Reiter reiter) {
		this.reiter = reiter;
	}

}
