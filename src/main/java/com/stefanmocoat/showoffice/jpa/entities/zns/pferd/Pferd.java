package com.stefanmocoat.showoffice.jpa.entities.zns.pferd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanmocoat.showoffice.jpa.entities.AbstractEntity;
import com.stefanmocoat.showoffice.jpa.entities.zns.verein.Verein;

/**
 * Import PFERD01.DAT
 */
@Entity
public class Pferd extends AbstractEntity {

	@Column(length = 4)
	private String kopfnummer;

	@Column(length = 30)
	private String pferdename;

	/*
	 * Bei ausl. Pferden wird eine zufällige Systemnummer generiert. Daher keine
	 * gültige Lebensnummer. Nicht für Pferdesuche verwenden!
	 */
	@Column(length = 9)
	private String lebensnummer;

	@Column(length = 1)
	private String geschlecht;

	@Column(length = 4)
	private String gebJahr;

	@ManyToOne
	@JsonIgnore	
	private PferdeFarbe farbe;

	@Column(length = 15)
	private String abstammung;

	@ManyToOne
	@JsonIgnore
	private Verein verein;

	@Column(length = 4)
	private String letzteZahlungJahr;

	// Standard BLANK
	@Column(length = 75)
	private String verantwortlichePerson;

	// Standard BLANK
	@Column(length = 30)
	private String vater;

	// Standard BLANK
	@Column(length = 10)
	private String feiPass;

	@Column(length = 10)
	private String satznummerDesPferdes;

	public String getKopfnummer() {
		return kopfnummer;
	}

	public void setKopfnummer(String kopfnummer) {
		this.kopfnummer = kopfnummer;
	}

	public String getPferdename() {
		return pferdename;
	}

	public void setPferdename(String pferdename) {
		this.pferdename = pferdename;
	}

	public Verein getVerein() {
		return verein;
	}

	public void setVerein(Verein verein) {
		this.verein = verein;
	}

	public String getLebensnummer() {
		return lebensnummer;
	}

	public void setLebensnummer(String lebensnummer) {
		this.lebensnummer = lebensnummer;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getGebJahr() {
		return gebJahr;
	}

	public void setGebJahr(String gebJahr) {
		this.gebJahr = gebJahr;
	}

	public PferdeFarbe getFarbe() {
		return farbe;
	}

	public void setFarbe(PferdeFarbe farbe) {
		this.farbe = farbe;
	}

	public String getAbstammung() {
		return abstammung;
	}

	public void setAbstammung(String abstammung) {
		this.abstammung = abstammung;
	}

	public String getLetzteZahlungJahr() {
		return letzteZahlungJahr;
	}

	public void setLetzteZahlungJahr(String letzteZahlungJahr) {
		this.letzteZahlungJahr = letzteZahlungJahr;
	}

	public String getVerantwortlichePerson() {
		return verantwortlichePerson;
	}

	public void setVerantwortlichePerson(String verantwortlichePerson) {
		this.verantwortlichePerson = verantwortlichePerson;
	}

	public String getVater() {
		return vater;
	}

	public void setVater(String vater) {
		this.vater = vater;
	}

	public String getFeiPass() {
		return feiPass;
	}

	public void setFeiPass(String feiPass) {
		this.feiPass = feiPass;
	}

	public String getSatznummerDesPferdes() {
		return satznummerDesPferdes;
	}

	public void setSatznummerDesPferdes(String satznummerDesPferdes) {
		this.satznummerDesPferdes = satznummerDesPferdes;
	}
}
