package com.stefanmocoat.showoffice.jpa.entities.zns;

import com.stefanmocoat.showoffice.jpa.entities.PferdeGeschlecht;
import com.stefanmocoat.showoffice.jpa.entities.PferdeFarbe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GenanntePferde {

    @Id
    @GeneratedValue
    private Long genanntePferde_ID;

    @Column(length = 4)
    private String KOPFNUMMER;

    @Column(length = 30)
    private String PFERDENAME;

    @Column(length = 9)
    private Long LEBENSNUMMER;

    @Column(length = 1)
    private PferdeGeschlecht GESCHLECHT;

    @Column(length = 4)
    private Integer GEBURTS_JAHR; // FORMAT: 9999

    @Column(length = 15)
    private PferdeFarbe FARBE;

    @Column(length = 15)
    private PferdeAbstammung ABSTAMMUNG;

    @Column(length = 10)
    private String FEI_PASS;

    @Column(length = 4)
    private Integer VEREIN;

    @Column(length = 4)
    private Integer JAHR_letzte_Zahlung;

    @Column(length = 75)
    private String VERANTWORTLICHE_PERSON; // Familienname, Vorname

    @Column(length = 30)
    private String VERERBER; // Vater des Pferdes

    @Column(length = 10)
    private String SATZNUMMER_DES_PFERDES;

    public GenanntePferde() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GENANNTE_PFERDE{");
        sb.append("genanntePferde_ID=").append(genanntePferde_ID);
        sb.append(", KOPFNUMMER='").append(KOPFNUMMER).append('\'');
        sb.append(", PFERDENAME='").append(PFERDENAME).append('\'');
        sb.append(", LEBENSNUMMER=").append(LEBENSNUMMER);
        sb.append(", GESCHLECHT=").append(GESCHLECHT);
        sb.append(", GEBURTS_JAHR=").append(GEBURTS_JAHR);
        sb.append(", FARBE=").append(FARBE);
        sb.append(", ABSTAMMUNG=").append(ABSTAMMUNG);
        sb.append(", FEI_PASS='").append(FEI_PASS).append('\'');
        sb.append(", VEREIN=").append(VEREIN);
        sb.append(", JAHR_letzte_Zahlung=").append(JAHR_letzte_Zahlung);
        sb.append(", VERANTWORTLICHE_PERSON='").append(VERANTWORTLICHE_PERSON).append('\'');
        sb.append(", VERERBER='").append(VERERBER).append('\'');
        sb.append(", SATZNUMMER_DES_PFERDES='").append(SATZNUMMER_DES_PFERDES).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
