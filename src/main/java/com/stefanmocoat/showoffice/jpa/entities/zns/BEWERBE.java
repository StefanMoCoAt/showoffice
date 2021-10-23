package com.stefanmocoat.showoffice.jpa.entities.zns;

import com.stefanmocoat.showoffice.jpa.entities.KATEGORIE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class BEWERBE {

    @Id
    @GeneratedValue
    private Long bewerbe_ID;

    @Column(length = 1)
    private String ID;

    @Column(length = 2)
    private Integer BEWERBNUMMER;

    @Column(length = 1)
    private Integer ABTEILUNG;

    @Column(length = 35)
    private String BEWERBNAME;

    @Column(length = 4)
    private String KLASSE;

    @Column(length = 8)
    private KATEGORIE KATEGORIE;

    @Column(length = 8)
    private Date DATUM;

    @Column(length = 3)
    private Integer BEWERBNUMMER_3STELLIG;

    public BEWERBE() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BEWERBE{");
        sb.append("bewerbe_ID=").append(bewerbe_ID);
        sb.append(", ID='").append(ID).append('\'');
        sb.append(", BEWERBNUMMER=").append(BEWERBNUMMER);
        sb.append(", ABTEILUNG=").append(ABTEILUNG);
        sb.append(", BEWERBNAME='").append(BEWERBNAME).append('\'');
        sb.append(", KLASSE='").append(KLASSE).append('\'');
        sb.append(", KATEGORIE=").append(KATEGORIE);
        sb.append(", DATUM=").append(DATUM);
        sb.append(", BEWERBNUMMER_3STELLIG=").append(BEWERBNUMMER_3STELLIG);
        sb.append('}');
        return sb.toString();
    }
}
