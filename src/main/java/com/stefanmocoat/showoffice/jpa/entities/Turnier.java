package com.stefanmocoat.showoffice.jpa.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Turnier extends AbstractEntity {

	private String number;

	private String name;

	private String ort;

	private Date von;

	private Date bis;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Kategorie> kategorien = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "turnier_ID")
	private Set<Bewerb> bewerbe = new HashSet<>();

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Date getVon() {
		return von;
	}

	public void setVon(Date von) {
		this.von = von;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}

	public Set<Kategorie> getKategorien() {
		return kategorien;
	}

	public void setKategorien(Set<Kategorie> kategorien) {
		this.kategorien = kategorien;
	}

	public Set<Bewerb> getBewerbe() {
		return bewerbe;
	}

	public void setBewerbe(Set<Bewerb> bewerbe) {
		this.bewerbe = bewerbe;
	}

}
