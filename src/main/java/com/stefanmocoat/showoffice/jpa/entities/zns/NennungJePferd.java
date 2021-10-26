package com.stefanmocoat.showoffice.jpa.entities.zns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NennungJePferd {

    @Id
    @GeneratedValue
    private Long nennungJePferdID;

    @Column(length = 4)
    private String kopfnummer;

    @Column(length = 30)
    private String pferdename;

    @Column(length = 6)
    private String satznummerDesReiters;

    @Column(length = 75)
    private String reiter; // Familienname Vorname

    @Column(length = 2)
    private Integer sperreCode; // siehe Nennliste. Der höchste Fehercode der bei den Bewerben aufgetreten ist, wird hier eingetragen. Teilnahmeberechtigung kontrollieren!

    @Column(length = 5)
    private Integer acconto; // 3 ganze Stellen, 2 Dezimalstellen ohne Kommazeichen BEITRAG DER MIT VERANSTALTER VERRECHNET WIRD

    @Column(length = 1)
    private Integer stall; // 0 = kein Stall, 2 Box bestellt Pro Pferd nur eine Box

    @Column(length = 37)
    private String genannteBewerbe; // Bewerbe getrennt durch "," Bewerbnummer ohne vorlaufende Nullen, ohne Abteilungsnummer

    @Column(length = 5)
    private Integer bezahlt; // 3 ganze Stellen, 2 Dezimalstellen, ohne Kommazeichen. BETRAG DER VOM NENNER EINBEZAHLT WURDE (zu Kontrollzwecken)

    @Column(length = 6)
    private String ersatzreiterSatznummer;

    @Column(length = 75)
    private String ersatzreiterFamiliennameVorname;

    @Column(length = 10)
    private String satznummerDesPferdes;

    public NennungJePferd() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NENNUNG_JE_PFERD{");
        sb.append("nennung_je_pferd_ID=").append(nennungJePferdID);
        sb.append(", KOPFNUMMER='").append(kopfnummer).append('\'');
        sb.append(", PFERDENAME='").append(pferdename).append('\'');
        sb.append(", SATZNUMMER_DES_REITERS='").append(satznummerDesReiters).append('\'');
        sb.append(", REITER='").append(reiter).append('\'');
        sb.append(", SPERRE_CODE=").append(sperreCode);
        sb.append(", ACCONTO=").append(acconto);
        sb.append(", STALL=").append(stall);
        sb.append(", GENANNTE_BEWERBE='").append(genannteBewerbe).append('\'');
        sb.append(", BEZAHLT=").append(bezahlt);
        sb.append(", ERSATZREITER_SATZNUMMER='").append(ersatzreiterSatznummer).append('\'');
        sb.append(", ERSATZREITER_FAMILIENNAME_VORNAME='").append(ersatzreiterFamiliennameVorname).append('\'');
        sb.append(", SATZNUMMER_DES_PFERDES='").append(satznummerDesPferdes).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
