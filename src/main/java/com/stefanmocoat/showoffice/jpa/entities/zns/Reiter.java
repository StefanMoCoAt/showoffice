package com.stefanmocoat.showoffice.jpa.entities.zns;

import javax.persistence.*;

/**
 * Import LIZENZ01.DAT
 */
@Entity
public class Reiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reiterId;

    @Column
    private String satzNrReiter;

    @Column
    private String familienname;

    @Column
    private String vorname;

    @Column
    private String budesland;

    @Column
    private String vereinsname;

    @Column
    private String nationalitaet;

    @Column
    private String lizenz;

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

    public long getId() {
        return reiterId;
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

    public String getLizenz() {
        return lizenz;
    }

    public void setLizenz(String reiterlizenz) {
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
