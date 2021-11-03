package com.stefanmocoat.showoffice.jpa.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Bewerb extends AbstractEntity {

	private String nummer;

	private int abteilung;

	private String name;

	private Klasse klasse;

	private Kategorie kategorie;

	private Date datum;

	private String subNummer;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "bewerb_ID")
	private Set<Paarung> paarungen = new HashSet<>();

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public int getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(int abteilung) {
		this.abteilung = abteilung;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getSubNummer() {
		return subNummer;
	}

	public void setSubNummer(String subNummer) {
		this.subNummer = subNummer;
	}

	public Set<Paarung> getPaarungen() {
		return paarungen;
	}

	public void setPaarungen(Set<Paarung> paarungen) {
		this.paarungen = paarungen;
	}

}
