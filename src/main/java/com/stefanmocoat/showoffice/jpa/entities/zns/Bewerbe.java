package com.stefanmocoat.showoffice.jpa.entities.zns;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.stefanmocoat.showoffice.jpa.entities.Kategorie;

@Entity
public class Bewerbe {

	@Id
	@GeneratedValue
	private Long bewerbe_ID;

	@Column(length = 1)
	private String id;

	@Column(length = 2)
	private Integer bewerbnummer;

	@Column(length = 1)
	private Integer abteilung;

	@Column(length = 35)
	private String bewerbname;

	@Column(length = 4)
	private String klasse;

	@Column(length = 8)
	private Kategorie kategorie;

	@Column(length = 8)
	private Date datum;

	@Column(length = 3)
	private Integer bewerbnummer_3stellig;

	public Bewerbe() {
	}

	public Long getBewerbe_ID() {
		return bewerbe_ID;
	}

	public void setBewerbe_ID(Long bewerbe_ID) {
		this.bewerbe_ID = bewerbe_ID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getBewerbnummer() {
		return bewerbnummer;
	}

	public void setBewerbnummer(Integer bewerbnummer) {
		this.bewerbnummer = bewerbnummer;
	}

	public Integer getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(Integer abteilung) {
		this.abteilung = abteilung;
	}

	public String getBewerbname() {
		return bewerbname;
	}

	public void setBewerbname(String bewerbname) {
		this.bewerbname = bewerbname;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
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

	public Integer getBewerbnummer_3stellig() {
		return bewerbnummer_3stellig;
	}

	public void setBewerbnummer_3stellig(Integer bewerbnummer_3stellig) {
		this.bewerbnummer_3stellig = bewerbnummer_3stellig;
	}

}
