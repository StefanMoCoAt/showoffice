package com.stefanmocoat.showoffice.jpa.entities.zns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NENNUNG_JE_PFERD {

    @Id
    @GeneratedValue
    private Long nennung_je_pferd_ID;

    @Column(length = 4)
    private String KOPFNUMMER;

    @Column(length = 30)
    private String PFERDENAME;

    @Column(length = 6)
    private String SATZNUMMER_DES_REITERS;

    @Column(length = 75)
    private String REITER; // Familienname Vorname

    @Column(length = 2)
    private Integer SPERRE_CODE; // siehe Nennliste. Der höchste Fehercode der bei den Bewerben aufgetreten ist, wird hier eingetragen. Teilnahmeberechtigung kontrollieren!

    @Column(length = 5)
    private Integer ACCONTO; // 3 ganze Stellen, 2 Dezimalstellen ohne Kommazeichen BEITRAG DER MIT VERANSTALTER VERRECHNET WIRD

    @Column(length = 1)
    private Integer STALL; // 0 = kein Stall, 2 Box bestellt Pro Pferd nur eine Box

    @Column(length = 37)
    private String GENANNTE_BEWERBE; // Bewerbe getrennt durch "," Bewerbnummer ohne vorlaufende Nullen, ohne Abteilungsnummer

    @Column(length = 5)
    private Integer BEZAHLT; // 3 ganze Stellen, 2 Dezimalstellen, ohne Kommazeichen. BETRAG DER VOM NENNER EINBEZAHLT WURDE (zu Kontrollzwecken)

    @Column(length = 6)
    private String ERSATZREITER_SATZNUMMER;

    @Column(length = 75)
    private String ERSATZREITER_FAMILIENNAME_VORNAME;

    @Column(length = 10)
    private String SATZNUMMER_DES_PFERDES;

    public NENNUNG_JE_PFERD() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NENNUNG_JE_PFERD{");
        sb.append("nennung_je_pferd_ID=").append(nennung_je_pferd_ID);
        sb.append(", KOPFNUMMER='").append(KOPFNUMMER).append('\'');
        sb.append(", PFERDENAME='").append(PFERDENAME).append('\'');
        sb.append(", SATZNUMMER_DES_REITERS='").append(SATZNUMMER_DES_REITERS).append('\'');
        sb.append(", REITER='").append(REITER).append('\'');
        sb.append(", SPERRE_CODE=").append(SPERRE_CODE);
        sb.append(", ACCONTO=").append(ACCONTO);
        sb.append(", STALL=").append(STALL);
        sb.append(", GENANNTE_BEWERBE='").append(GENANNTE_BEWERBE).append('\'');
        sb.append(", BEZAHLT=").append(BEZAHLT);
        sb.append(", ERSATZREITER_SATZNUMMER='").append(ERSATZREITER_SATZNUMMER).append('\'');
        sb.append(", ERSATZREITER_FAMILIENNAME_VORNAME='").append(ERSATZREITER_FAMILIENNAME_VORNAME).append('\'');
        sb.append(", SATZNUMMER_DES_PFERDES='").append(SATZNUMMER_DES_PFERDES).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
