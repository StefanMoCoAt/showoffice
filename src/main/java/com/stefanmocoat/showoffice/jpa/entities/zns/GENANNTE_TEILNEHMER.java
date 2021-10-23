package com.stefanmocoat.showoffice.jpa.entities.zns;

import com.stefanmocoat.showoffice.jpa.entities.ALTERSKLASSE;
import com.stefanmocoat.showoffice.jpa.entities.BUNDESLAND;
import org.junit.platform.commons.util.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * GENANNTE TEILNEHMER
 * Kopfzeile "RREITERLISTE"
 * OEPS Pflichtenhelft 2021 V2.4
 */

@Entity
public class GENANNTE_TEILNEHMER {

    @Id
    @GeneratedValue
    private Long genannteTeilnehmer_ID;

    @Column(length = 6)
    private String SATZNUMMER_DES_REITERS;

    @Column(length = 50)
    private String FAMILIENNAME;

    @Column(length = 25)
    private String VORNAME;

    @Column(length = 2)
    private BUNDESLAND BUNDESLAND;

    @Column(length = 50)
    private String VEREINSNAME;

    @Column(length = 3)
    private String NATIONALITAET;

    @Column(length = 4)
    private String REITERLIZENZ;

    @Column(length = 1)
    private String STARTKARTE;

    @Column(length = 2)
    private String FAHRLIZENZ;

    @Column(length = 3)
    private ALTERSKLASSE ALTERSKLASSE;

    @Column(length = 8)
    private Long MITGLIEDSNUMMER;

    @Column(length = 21)
    private String TELEFONNUMMER; // Standard = BLANK

    @Column(length = 1)
    private Character KADER; // 'K' = Kader Standard = BLANK

    @Column(length = 4)
    private Integer JAHR_letzte_Zahlung;

    @Column(length = 1)
    private Character GESCHLECHT; // 'W' bzw. 'M'

    @Column(length = 8)
    private Date GEBURTSDATUM; // FORMAT: JJJJMMTT

    @Column(length = 10)
    private String FEI_ID;

    @Column(length = 1)
    private Character SPERRLISTE; // 'S' = Info auf Sperrliste nachsehen / Standard = BLANK

    public GENANNTE_TEILNEHMER() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GENANNTE_TEILNEHMER{");
        sb.append("genannteTeilnehmer_ID=").append(genannteTeilnehmer_ID);
        sb.append(", SATZNUMMER_DES_REITERS='").append(SATZNUMMER_DES_REITERS).append('\'');
        sb.append(", FAMILIENNAME='").append(FAMILIENNAME).append('\'');
        sb.append(", VORNAME='").append(VORNAME).append('\'');
        sb.append(", BUNDESLAND=").append(BUNDESLAND);
        sb.append(", VEREINSNAME='").append(VEREINSNAME).append('\'');
        sb.append(", NATIONALITAET='").append(NATIONALITAET).append('\'');
        sb.append(", REITERLIZENZ='").append(REITERLIZENZ).append('\'');
        sb.append(", STARTKARTE='").append(STARTKARTE).append('\'');
        sb.append(", FAHRLIZENZ='").append(FAHRLIZENZ).append('\'');
        sb.append(", ALTERSKLASSE=").append(ALTERSKLASSE);
        sb.append(", MITGLIEDSNUMMER=").append(MITGLIEDSNUMMER);
        sb.append(", TELEFONNUMMER='").append(TELEFONNUMMER).append('\'');
        sb.append(", KADER=").append(KADER);
        sb.append(", JAHR_letzte_Zahlung=").append(JAHR_letzte_Zahlung);
        sb.append(", GESCHLECHT=").append(GESCHLECHT);
        sb.append(", GEBURTSDATUM=").append(GEBURTSDATUM);
        sb.append(", FEI_ID='").append(FEI_ID).append('\'');
        sb.append(", SPERRLISTE=").append(SPERRLISTE);
        sb.append('}');
        return sb.toString();
    }
}
