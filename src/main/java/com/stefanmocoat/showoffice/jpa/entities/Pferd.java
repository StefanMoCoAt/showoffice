package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

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
	private PferdeGeschlecht geschlecht;

	@Column(length = 4)
	private Year gebJahr;
	//private String gebJahr;

	@ManyToOne
	@JsonIgnore	
	private PferdeFarbe farbe;

	@ManyToOne
	@JsonIgnore
	private PferdAbstammung abstammung;

	@ManyToOne
	@JsonIgnore
	private Verein verein;

	@Column(length = 4)
	private Year letzteZahlungJahr;

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

	public PferdeGeschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(PferdeGeschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

	public Year getGebJahr() {
		return gebJahr;
	}

	public void setGebJahr(Year gebJahr) {
		this.gebJahr = gebJahr;
	}

	public PferdeFarbe getFarbe() {
		return farbe;
	}

	public void setFarbe(PferdeFarbe farbe) {
		this.farbe = farbe;
	}

	public PferdAbstammung getAbstammung() {
		return abstammung;
	}

	public void setAbstammung(PferdAbstammung abstammung) {
		this.abstammung = abstammung;
	}

	public Year getLetzteZahlungJahr() {
		return letzteZahlungJahr;
	}

	public void setLetzteZahlungJahr(Year letzteZahlungJahr) {
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
