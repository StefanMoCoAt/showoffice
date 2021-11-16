package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Import LIZENZ01.DAT
 */
@Entity
public class Reiter extends AbstractEntity {

    @Column
    private String satzNrReiter;

    @Column
    private String familienname;

    @Column
    private String vorname;

    @Column(length = 2)
    private String budesland;

    @Column(length = 50)
    private String vereinsname;


    @Column(length = 3)
    private String nationalitaet;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private Lizenz lizenz;

    @Column
    private String startkarte;

    @Column
    private String fahrlizenz;

    @Column
    private String altersKlJgJrU25; // "JG"=Jugendlich "JR"=Junior "25"=U25

    @Column
    private String altersKlY; // "Y"=JungerReiter

    @Column
    private String mitgliedsnummer;

    @ManyToOne
	@JsonIgnore
	private Verein verein;
    
    @Column
    private String telefonnummer;

    @Column
    private String kader;

    @Column
    private String letzteZahlungJahr;

    @Column
    private String geschlecht; // "W" "M"

    @Column
    private String geburtsdatum; // "yyyyMMdd"

    @Column
    private String feiId;

    @Column
    private String sperrliste;

    @Column
    private String lizenzinfo;

/*    @Transient
    private String fullName;*/

    // Getter Setter
    public String getFullName() {
        return this.vorname.concat(" ").concat(this.familienname);
    }

    public String getSatzNrReiter() {
        return satzNrReiter;
    }

    public void setSatzNrReiter(String satznummerDesReiters) {
        this.satzNrReiter = satznummerDesReiters;
    }

    public String getFamilienname() {
        return familienname;
    }

    public void setFamilienname(String familienname) {
        this.familienname = familienname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getBudesland() {
        return budesland;
    }

    public void setBudesland(String budesland) {
        this.budesland = budesland;
    }

    public String getVereinsname() {
        return vereinsname;
    }

    public void setVereinsname(String vereinsname) {
        this.vereinsname = vereinsname;
    }

    public String getNationalitaet() {
        return nationalitaet;
    }

    public void setNationalitaet(String nationalitaet) {
        this.nationalitaet = nationalitaet;
    }

    public Lizenz getLizenz() {
        return lizenz;
    }

    public void setLizenz(Lizenz reiterlizenz) {
        this.lizenz = reiterlizenz;
    }

    public String getStartkarte() {
        return startkarte;
    }

    public void setStartkarte(String startkarte) {
        this.startkarte = startkarte;
    }

    public String getFahrlizenz() {
        return fahrlizenz;
    }

    public void setFahrlizenz(String fahrlizenz) {
        this.fahrlizenz = fahrlizenz;
    }

    public String getAltersKlJgJrU25() {
        return altersKlJgJrU25;
    }

    public void setAltersKlJgJrU25(String altersklasseJugendJuniorU25) {
        this.altersKlJgJrU25 = altersklasseJugendJuniorU25;
    }

    public String getAltersKlY() {
        return altersKlY;
    }

    public void setAltersKlY(String altersklasseJungeReiter) {
        this.altersKlY = altersklasseJungeReiter;
    }

    public String getMitgliedsnummer() {
        return mitgliedsnummer;
    }

    public void setMitgliedsnummer(String mitgliedsnummer) {
        this.mitgliedsnummer = mitgliedsnummer;
    }

    public Verein getVerein() {
		return verein;
	}

	public void setVerein(Verein verein) {
		this.verein = verein;
	}

	public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getKader() {
        return kader;
    }

    public void setKader(String kader) {
        this.kader = kader;
    }

    public String getLetzteZahlungJahr() {
        return letzteZahlungJahr;
    }

    public void setLetzteZahlungJahr(String letzteZahlungJahr) {
        this.letzteZahlungJahr = letzteZahlungJahr;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getFeiId() {
        return feiId;
    }

    public void setFeiId(String feiId) {
        this.feiId = feiId;
    }

    public String getSperrliste() {
        return sperrliste;
    }

    public void setSperrliste(String sperrliste) {
        this.sperrliste = sperrliste;
    }

    public String getLizenzinfo() {
        return lizenzinfo;
    }

    public void setLizenzinfo(String lizenzinfo) {
        this.lizenzinfo = lizenzinfo;
    }


}
